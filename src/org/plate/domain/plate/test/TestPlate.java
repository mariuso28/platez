package org.plate.domain.plate.test;

import org.apache.log4j.Logger;
import org.plate.domain.plate.DefaultPlate;
import org.plate.domain.plate.Plate;
import org.plate.home.persistence.Home;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPlate {
	
	private static Logger log = Logger.getLogger(TestPlate.class);
	
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"plate-service.xml");

		Home home = (Home) context.getBean("home");
		Plate plate = DefaultPlate.getPlate();
		
		log.info(plate);
		
		home.getPlateDao().store(plate);
		
		plate = home.getPlateDao().getByRegNo("WUY 9119");
		
		log.info(plate);
		
		log.info("Done");
	}
}
