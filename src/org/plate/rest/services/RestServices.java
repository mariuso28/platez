package org.plate.rest.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.plate.domain.plate.Plate;
import org.plate.domain.plate.sell.PlateOffer;
import org.plate.domain.plate.sell.PlateSell;
import org.plate.json.PlateJson;
import org.plate.json.PlateOfferJson;
import org.plate.json.PlateSellJson;
import org.plate.json.ProfileJson;
import org.plate.json.PunterJson;
import org.plate.json.QueryOnDigitsParamsJson;
import org.plate.json.QueryOnPlateParamsJson;
import org.plate.json.QueryParamsJson;
import org.plate.persistence.PersistenceDuplicateKeyException;
import org.plate.query.QueryParams;
import org.plate.query.persistence.QueryDao;
import org.plate.services.Services;
import org.plate.services.validator.BaseUserValidator;
import org.plate.services.validator.ValidatorException;
import org.plate.user.BaseUser;
import org.plate.user.punter.Punter;
import org.springframework.beans.factory.annotation.Autowired;

public class RestServices {
private static final Logger log = Logger.getLogger(RestServices.class);
	
	@Autowired
	private Services services;
	
	public RestServices()
	{
	}
	
	public QueryParamsJson getQueryParams()
	{
		QueryParamsJson qp = new QueryParamsJson();
		qp.setPrefix(QueryParams.getValidPrefix());
		qp.setLetter1(QueryParams.getValidLetter());
		qp.setLetter2(QueryParams.getValidLetter());
		qp.setNumber1(QueryParams.getValidNumber1());
		qp.setNumber2(QueryParams.getValidNumber());
		qp.setNumber3(QueryParams.getValidNumber());
		qp.setNumber4(QueryParams.getValidNumber());
		qp.setSuffix(QueryParams.getValidSuffix());
		qp.setSpecials(QueryParams.getValidSpecials());
		return qp;
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
		pj.setPlateSell(createPlateSell(p.getPlateSell()));
		return pj;
	}

	private PlateSellJson createPlateSell(PlateSell plateSell) {
		if (plateSell==null)
			return null;
		PlateSellJson psl = new PlateSellJson();
		psl.setId(plateSell.getId());
		psl.setPlateId(plateSell.getPlate().getId());
		psl.setSellDate(plateSell.getSellDate());
		psl.setSellerEmail(plateSell.getSellerEmail());
		psl.setOffers(createPlateOffers(plateSell.getOffers(),psl));
		return psl;
	}

	private List<PlateOfferJson> createPlateOffers(List<PlateOffer> plateOffers, PlateSellJson psj) {
		List<PlateOfferJson> pos = new ArrayList<PlateOfferJson>();
		Set<String> distinct = new HashSet<String>();
		for (PlateOffer po : plateOffers)
		{
			PlateOfferJson poj = new PlateOfferJson();
			poj.setBuyerEmail(po.getBuyerEmail());
			poj.setId(po.getId());
			poj.setOffer(po.getOffer());
			poj.setRegNo(po.getRegNo());
			poj.setStatus(po.getStatus());
			pos.add(poj);
			if (!distinct.contains(po.getRegNo()))
				distinct.add(po.getRegNo());
		}
		if (psj!=null)
			psj.setOffersDistinctCount(distinct.size());
		return pos;
	}

	public List<PlateJson> queryPlate(QueryOnPlateParamsJson params) {
		QueryDao qd = services.getHome().getQueryDao();
		List<Plate> plates;
		try
		{
			plates = qd.QueryOnPlate(params);
		}
		catch (Exception e)
		{
			log.error(e);
			throw new RestServicesException("Could not query plates - contact support");
		}
		log.info("Got Plates # " + plates.size());
		List<PlateJson> pjs = new ArrayList<PlateJson>();
		for (Plate p : plates)
			pjs.add(createPlateJson(p));
		return pjs;
	}

	public List<PlateJson> queryDigits(QueryOnDigitsParamsJson params) {
		QueryDao qd = services.getHome().getQueryDao();
		List<Plate> plates;
		try
		{
			plates = qd.QueryOnDigits(params);
		}
		catch (Exception e)
		{
			log.error(e);
			throw new RestServicesException("Could not query plates - contact support");
		}
		log.info("Got Plates # " + plates.size());
		List<PlateJson> pjs = new ArrayList<PlateJson>();
		for (Plate p : plates)
			pjs.add(createPlateJson(p));
		return pjs;
	}

	public void register(ProfileJson profile) {
		BaseUser bu = new BaseUser();
		BaseUserValidator bv = new BaseUserValidator();
		bu.setContact(profile.getContact());
		bu.setEmail(profile.getEmail());
		bu.setPhone(profile.getPhone());
		bu.setPassword(profile.getPassword());
		
		bu.setRole(bu.getRole());
		try
		{
			bv.validate(bu);
			// do encryption here after validate
			services.getHome().getBaseUserDao().store(bu);
		}
		catch (ValidatorException e2)
		{
			throw new RestServicesException(e2.getMessage());
		}
		catch (PersistenceDuplicateKeyException e1)
		{
			throw new RestServicesException(e1.getMessage());
		}
		catch (Exception e)
		{
			log.error(e);
			throw new RestServicesException("Could not register user - contact support");
		}
	}

	public PunterJson getPunter(String email) {
		Punter punter = services.getHome().getPunterDao().getByEmail(email);
		if (punter == null)
			throw new RestServicesException("user " + email + " cannot be found");
		return populatePunter(punter);
	}

	private PunterJson populatePunter(Punter punter) {
		PunterJson pj = new PunterJson();
		pj.setProfile(populateProfile(punter));
		Map<String,PlateSellJson> plateSells = new HashMap<String,PlateSellJson>();
		for (PlateSell ps : punter.getPlateSells())
			plateSells.put(ps.getPlate().getRegNo(),createPlateSell(ps));
		pj.setPlateSells(plateSells);
		Map<String,List<PlateOfferJson>> plateOffers = new HashMap<String,List<PlateOfferJson>>();
		List<PlateOfferJson> pos = createPlateOffers(punter.getOffers(),null);
		for (PlateOfferJson po : pos)
		{
			List<PlateOfferJson> pls = plateOffers.get(po.getRegNo());
			if (pls == null)
			{
				pls = new ArrayList<PlateOfferJson>();
				plateOffers.put(po.getRegNo(),pls);
			}
			pls.add(po);
		}
		pj.setOffers(plateOffers);
		return pj;
	}
	
	private ProfileJson populateProfile(BaseUser bu) {
		ProfileJson pf = new ProfileJson();
		pf.setContact(bu.getContact());
		pf.setEmail(bu.getEmail());
		pf.setPhone(bu.getPhone());
		return pf;
	}
}
