package org.plate.user.initialize;

import org.apache.log4j.Logger;
import org.plate.home.persistence.Home;
import org.plate.user.BaseUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitializeAgent 
{
	private static Logger log = Logger.getLogger(InitializeAgent.class);
	
	private static BaseUser createAgent()
	{
		BaseUser bu = new BaseUser();
		bu.setContact("des");
		bu.setEmail("des88@test.com");
		bu.setPassword("88888888");
		bu.setPhone("0102202006");
		bu.setRole(BaseUser.ROLE_AGENT);
		return bu;
	}
	
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"plate-service.xml");

		Home home = (Home) context.getBean("home");
		BaseUser bu = createAgent();
		try
		{
			home.getBaseUserDao().store(bu);
		}
		catch (Exception e)
		{
			log.error(e.getMessage());
			System.exit(1);
		}
		bu = home.getBaseUserDao().getByEmail("des88@test.com");
		
		log.info(bu);
		
		bu.setEnabled(true);
		home.getBaseUserDao().update(bu);
		
		bu = home.getBaseUserDao().getById(bu.getId());
		
		log.info(bu);
		
		log.info("Done");
	}
}
