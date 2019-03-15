package org.plate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Override
    public void configure(HttpSecurity http) throws Exception {
		http
			.antMatcher("/px4/api/**")
			.authorizeRequests()
			.antMatchers(
					"/px4/api/a/**",
					"/px4/api/anon/**"
					)
			.permitAll()			
			.antMatchers(
					"/px4/api/punter/**"
					)
			.access("hasRole('ROLE_PUNTER')")
			.antMatchers(
					"/px4/api/agent/**"
					)
			.access("hasRole('ROLE_AGENT')")
			.antMatchers(
					"/px4/api/auctioneer/**"
					)
			.access("hasRole('ROLE_AUCTIONEER')")
		;
    }

}