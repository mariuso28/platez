package org.plate.query.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.plate.domain.plate.Plate;
import org.plate.home.persistence.Home;
import org.plate.persistence.PersistenceRuntimeException;
import org.plate.query.QueryOnDigitsParams;
import org.plate.query.persistence.QueryDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QueryTestDigits {

	private static Logger log = Logger.getLogger(QueryTestDigits.class);
	
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"plate-service.xml");

		Home home = (Home) context.getBean("home");
		QueryDao qd = home.getQueryDao();
		QueryOnDigitsParams qpp = new QueryOnDigitsParams();
		qpp.setDoubleDigit(true);
		qpp.setPalindromic(true);
		
		try {
			List<Plate> plates = qd.QueryOnDigits(qpp);
			for (Plate p : plates)
				log.info(p);
			
		} catch (PersistenceRuntimeException e) {
			e.printStackTrace();
		}
		log.info("Done");
		System.exit(0);
	}
}
