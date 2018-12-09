package org.plate.query.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.plate.domain.plate.Plate;
import org.plate.home.persistence.Home;
import org.plate.json.QueryOnPlateParamsJson;
import org.plate.persistence.PersistenceRuntimeException;
import org.plate.query.QueryException;
import org.plate.query.persistence.QueryDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QueryTestPlate {

	private static Logger log = Logger.getLogger(QueryTestPlate.class);
	
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"plate-service.xml");

		Home home = (Home) context.getBean("home");
		QueryDao qd = home.getQueryDao();
		QueryOnPlateParamsJson qpp = new QueryOnPlateParamsJson();
		qpp.setPrefix("P");
		qpp.setLetter1("E");
		qpp.setLetter2("N");
		qpp.setNumber1("9");
		
		try {
			List<Plate> plates = qd.QueryOnPlate(qpp);
			for (Plate p : plates)
				log.info(p);
			
		} catch (PersistenceRuntimeException e) {
			e.printStackTrace();
		} catch (QueryException e) {
			e.printStackTrace();
		}
		
	}
}
