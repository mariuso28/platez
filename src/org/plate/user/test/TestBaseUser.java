package org.plate.user.test;

import org.apache.log4j.Logger;
import org.plate.home.persistence.Home;
import org.plate.user.BaseUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBaseUser 
{
	private static Logger log = Logger.getLogger(TestBaseUser.class);
	
	private static BaseUser createBaseUser()
	{
		BaseUser bu = new BaseUser();
		bu.setContact("pmk");
		bu.setEmail("pmk@test.com");
		bu.setPassword("88888888");
		bu.setPhone("0102202005");
	
		return bu;
	}
	
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"plate-service.xml");

		Home home = (Home) context.getBean("home");
		BaseUser bu = createBaseUser();
		home.getBaseUserDao().store(bu);
		
		bu = home.getBaseUserDao().getByEmail("pmk@test.com");
		
		log.info(bu);
		
		bu.setEnabled(true);
		home.getBaseUserDao().update(bu);
		
		bu = home.getBaseUserDao().getById(bu.getId());
		
		log.info(bu);
		
		log.info("Done");
	}
}
