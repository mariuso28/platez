package org.plate.config;

import javax.sql.DataSource;

import org.plate.config.service.CustomAuthenticationFailureHandler;
import org.plate.config.service.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService customUserDetailsService;
	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	@Autowired
	private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
	@Autowired
	private DataSource dataSource;

	@Bean(name="filterMultipartResolver")
	public CommonsMultipartResolver createMultipartResolver() {
		CommonsMultipartResolver resolver=new CommonsMultipartResolver();
		resolver.setMaxUploadSize(100000000);
		resolver.setDefaultEncoding("utf-8");
		return resolver;
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }

	@Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth
		.userDetailsService(customUserDetailsService)

		.and()
		.authenticationProvider(authenticationProvider())

		;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers(
				"/px4/web/anon/**",
				"/css/**/**",
				"/fonts/**",
				"/img/**",
				"/js/**",
				"/px4/oauth/token"
				)
		.permitAll()
		
		.antMatchers(
				"/px4/web/agent/**"
				)
		.access("hasRole('ROLE_AGENT')")
		
		.antMatchers(
				"/px4/web/punter/**"
				)
		.access("hasRole('ROLE_PUNTER')")
		
		.antMatchers(
				"/px4/web/auctioneer/**"
				)
		.access("hasRole('ROLE_AUCTIONEER')")
		
		.and().formLogin()
		.loginPage("/px4/web/anon/logon")
		.usernameParameter("email")
		.passwordParameter("password")
		.successHandler(customAuthenticationSuccessHandler)
		.failureHandler(customAuthenticationFailureHandler)
	//	.failureUrl("/logon/signin?error&message=Authentication%20Error")
		.permitAll()

		.and().logout()
		.permitAll()

	
		.and().sessionManagement()
		.invalidSessionUrl("/px4/web/anon/invalidSession")
		.and().exceptionHandling()
		.accessDeniedPage("/px4/web/anon/accessDenied")
		.and().csrf().disable()
		;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
	}

	@Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(customUserDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	
}