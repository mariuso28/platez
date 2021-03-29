package org.plate.importer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.plate.domain.plate.Plate;
import org.plate.domain.plate.sell.PlateSell;
import org.plate.home.persistence.Home;
import org.plate.user.punter.Punter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PlateImporter 
{
	private static Logger log = Logger.getLogger(PlateImporter.class);
	private static List<Plate> plates = new ArrayList<Plate>();
	
	private static void importPlates(File file,Home ph) throws Exception
	{
		Punter punter = ph.getPunterDao().getByEmail("jpj@test.com");
		GregorianCalendar gc = new GregorianCalendar();
		
		InputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(isr);
		int fcnt=0;
		String line;
		while ((line = br.readLine()) != null) {
				try{
					PlateParseRule pr = new PlateParseRule(line);
					ph.getPlateDao().store(pr.getPlate());
					Plate plate = pr.getPlate(); 
					PlateSell ps = new PlateSell();
					ps.setPlate(plate);
					ps.setSellDate(gc.getTime());
					ps.setSellerEmail(punter.getEmail());
					ph.getPlateSellDao().storePlateSell(ps);
					
					log.info(plate.getRegNo() + " - " + plate.getListPrice());
					plates.add(plate);
					fcnt++;
				}
				catch (PlateParseException e)
				{
					log.error(e.getMessage());
				}
		}
		log.info(fcnt + " plates imported for : " + file.getPath());
		br.close();
	}
	
	public static void importPremiumPlates(Home ph)
	{
		File file = new File("/home/pmk/repo/JPJ/support/premium/0307116.txt");
		try
    	 {
			importPlates(file,ph);
    	 }
    	 catch (Exception e)
    	 {
    		 log.error("ERROR ON FILE : " + file.getAbsolutePath() + " - " + e.getMessage());
    	 }
		log.info(" file successfully imported");
	}
	
	public static void importAllPlates(Home ph)
	{
		File folder = new File("/home/pmk/repo/JPJ/support/formatted");
 		File[] listOfFiles = folder.listFiles();

 		
 		int cnt = 0;
 		for (File file : listOfFiles) 
 		{
 			 try
 	    	 {
 				importPlates(file,ph);
 	    		cnt++;
 	    	 }
 	    	 catch (Exception e)
 	    	 {
 	    		 log.error("ERROR ON FILE : " + file.getAbsolutePath() + " - " + e.getMessage());
 	    	 }
 		}
 		log.info(cnt + " files successfully imported");
	}
	
	public static List<Plate> getPlates() {
		return plates;
	}

	public static void setPlates(List<Plate> plates) {
		PlateImporter.plates = plates;
	}
	
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"plate-service.xml");

		Home home = (Home) context.getBean("home");
		
		importPremiumPlates(home);
	}

}
