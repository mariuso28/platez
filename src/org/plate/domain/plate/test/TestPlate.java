package org.plate.domain.plate.test;

import java.util.GregorianCalendar;

import org.apache.log4j.Logger;
import org.plate.domain.plate.DefaultPlate;
import org.plate.domain.plate.Plate;
import org.plate.domain.plate.sell.PlateSell;
import org.plate.home.persistence.Home;
import org.plate.user.punter.Punter;
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
		Punter punter = home.getPunterDao().getByEmail("jpj@test.com");
		GregorianCalendar gc = new GregorianCalendar();
		
		
		log.info(plate);
		
		home.getPlateDao().store(plate);
		
		PlateSell ps = new PlateSell();
		ps.setPlate(plate);
		ps.setSellDate(gc.getTime());
		ps.setSellerEmail(punter.getEmail());
		home.getPlateSellDao().storePlateSell(ps);
		
		plate = home.getPlateDao().getByRegNo("WUY 9119");
		
		log.info(plate);
		
		log.info("Done");
	}
}
