package org.plate.user.initialize;

import org.apache.log4j.Logger;
import org.plate.home.persistence.Home;
import org.plate.user.BaseUser;
import org.plate.user.agent.Agent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CreateSampleUsers 
{
	private static Logger log = Logger.getLogger(CreateSampleUsers.class);
	
	private static BaseUser createAgent()
	{
		Agent bu = new Agent();
		bu.setContact("des");
		bu.setEmail("des88@test.com");
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		bu.setPassword(encoder.encode("88888888"));
		bu.setPhone("0102202006");
		bu.setRole(BaseUser.ROLE_AGENT);
		return bu;
	}
	
	private static BaseUser createPunter()
	{
		BaseUser bu = new BaseUser();
		bu.setContact("koko");
		bu.setEmail("koko@test.com");
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		bu.setPassword(encoder.encode("88888888"));
		bu.setPhone("0102202007");
		bu.setRole(BaseUser.ROLE_PUNTER);
		return bu;
	}
	
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"plate-service.xml");

		Home home = (Home) context.getBean("home");
		BaseUser agent = createAgent();
		BaseUser punter = createPunter();
		try
		{
			home.getBaseUserDao().store(agent);
			home.getBaseUserDao().store(punter);
		}
		catch (Exception e)
		{
			log.error(e.getMessage());
			System.exit(1);
		}
		agent = home.getBaseUserDao().getByEmail("des88@test.com");
		log.info(agent);
		
		punter = home.getBaseUserDao().getByEmail("koko@test.com");
		log.info(punter);
		
		log.info("Done");
	}
}
