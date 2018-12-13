package org.plate.user.initialize;

import org.apache.log4j.Logger;
import org.plate.home.persistence.Home;
import org.plate.user.BaseUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CreateJpjUser 
{
	private static Logger log = Logger.getLogger(CreateJpjUser.class);
	
	private static BaseUser createJpj()
	{
		BaseUser bu = new BaseUser();
		bu.setContact("JPJ");
		bu.setEmail("jpj@test.com");
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		bu.setPassword(encoder.encode("88888888"));
		bu.setPhone("0123456789");
		bu.setRole(BaseUser.ROLE_PUNTER);
		return bu;
	}
	
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"plate-service.xml");

		Home home = (Home) context.getBean("home");
		BaseUser punter = createJpj();
		try
		{
			home.getBaseUserDao().store(punter);
			punter = home.getBaseUserDao().getByEmail("jpj@test.com");
			punter.setEnabled(true);
			home.getBaseUserDao().update(punter);
		}
		catch (Exception e)
		{
			log.error(e.getMessage());
			System.exit(1);
		}
		punter = home.getBaseUserDao().getByEmail("koko@test.com");
		log.info(punter);
		
		log.info("Done");
	}
}
