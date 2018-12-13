package org.plate.user.initialize;

import org.apache.log4j.Logger;
import org.plate.home.persistence.Home;
import org.plate.user.BaseUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EnableSampleUsers 
{
	private static Logger log = Logger.getLogger(EnableSampleUsers.class);
	
	
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"plate-service.xml");

		Home home = (Home) context.getBean("home");
		
		BaseUser agent = home.getBaseUserDao().getByEmail("des88@test.com");
		log.info(agent);
		
		BaseUser punter = home.getBaseUserDao().getByEmail("koko@test.com");
		log.info(punter);
		
		agent.setEnabled(true);
		punter.setEnabled(true);
		try
		{
			home.getBaseUserDao().update(agent);
			home.getBaseUserDao().update(punter);
		}
		catch (Exception e)
		{
			log.error(e.getMessage());
			System.exit(1);
		}
		
		log.info("Done");
	}
}
