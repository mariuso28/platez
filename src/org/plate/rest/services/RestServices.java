package org.plate.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.plate.domain.plate.Plate;
import org.plate.json.PlateJson;
import org.plate.query.persistence.QueryDao;
import org.plate.services.Services;
import org.springframework.beans.factory.annotation.Autowired;

public class RestServices {
private static final Logger log = Logger.getLogger(RestServices.class);
	
	@Autowired
	private Services services;
	
	public RestServices()
	{
	}
	
	public List<PlateJson> getAllPlates()
	{
		QueryDao qd = services.getHome().getQueryDao();
		List<Plate> plates;
		try
		{
			plates = qd.QueryOnRating(Plate.RATINGNONE, Plate.LASTRATING);
		}
		catch (Exception e)
		{
			log.error(e);
			throw new RestServicesException("Could not get plates - contact support");
		}
		log.info("Got Plates # " + plates.size());
		List<PlateJson> pjs = new ArrayList<PlateJson>();
		for (Plate p : plates)
			pjs.add(createPlateJson(p));
		return pjs;
	}

	private PlateJson createPlateJson(Plate p) {
		PlateJson pj =  new PlateJson();
		pj.setListPrice(p.getListPrice());
		pj.setRating(p.getRating());
		pj.setRegNo(p.getRegNo());
		pj.setId(p.getId());
		return pj;
	}
}
