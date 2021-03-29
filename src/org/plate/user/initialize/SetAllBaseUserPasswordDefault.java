package org.plate.user.initialize;

import org.apache.log4j.Logger;
import org.plate.home.persistence.Home;
import org.plate.services.Services;
import org.plate.user.BaseUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SetAllBaseUserPasswordDefault 
{
	private static Logger log = Logger.getLogger(SetAllBaseUserPasswordDefault.class);
	
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"plate-service.xml");

		Services Services = (Services) context.getBean("services");
		Home home = Services.getHome();
	
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String encoded = encoder.encode("Coco2828");
		
		home.getBaseUserDao().setDefaultPasswordForAll(encoded);
		
		try {
			BaseUser hb = home.getBaseUserDao().getByEmail("koko@test.com");
			log.info("matches : " + encoder.matches("Coco2828", hb.getPassword()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
