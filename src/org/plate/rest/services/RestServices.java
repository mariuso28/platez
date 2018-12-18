package org.plate.rest.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
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
import org.plate.json.PlateOfferStatusJson;
import org.plate.json.PlateParamsJson;
import org.plate.json.PlatePublishJson;
import org.plate.json.PlateSellJson;
import org.plate.json.ProfileJson;
import org.plate.json.PunterJson;
import org.plate.json.QueryOnDigitsParamsJson;
import org.plate.json.QueryParamsJson;
import org.plate.json.SendPlateOfferJson;
import org.plate.persistence.PersistenceDuplicateKeyException;
import org.plate.query.QueryParams;
import org.plate.query.persistence.QueryDao;
import org.plate.services.Services;
import org.plate.services.validator.BaseUserValidator;
import org.plate.services.validator.ValidatorException;
import org.plate.user.BaseUser;
import org.plate.user.punter.Punter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

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

	public List<PlateJson> queryPlate(PlateParamsJson params) {
		alignParams(params);
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

	private void alignParams(PlateParamsJson params)
	{
		if (params.getLetter1().isEmpty() && !params.getLetter2().isEmpty())
		{
			params.setLetter1(params.getLetter2());
			params.setLetter2("");
		}
		String number = params.getNumber1() + params.getNumber2() + params.getNumber3() + params.getNumber4();
		number = number.trim();
		if (number.length()==0 || number.length()==4)
			return;
		params.setNumber2("");
		params.setNumber3("");
		params.setNumber4("");
		params.setNumber1("" + number.charAt(0));
		if (number.length()>1)	
			params.setNumber2("" + number.charAt(1));
		if (number.length()>2)	
			params.setNumber3("" + number.charAt(2));	
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

	public void register(ProfileJson profile,String role) {
		BaseUser bu = new BaseUser();
		bu.setRole(role);
		try
		{
			copyProfile(bu,profile);
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

	private void copyProfile(BaseUser bu,ProfileJson profile) throws ValidatorException
	{
		BaseUserValidator bv = new BaseUserValidator();
		bu.setContact(profile.getContact());
		bu.setEmail(profile.getEmail());
		bu.setPhone(profile.getPhone());
		bu.setPassword(profile.getPassword());
		bv.validate(bu);
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		bu.setPassword(encoder.encode(bu.getPassword()));
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
		Map<String,PlateOfferJson> plateOffers = new HashMap<String,PlateOfferJson>();
		List<PlateOfferJson> pos = createPlateOffers(punter.getOffers(),null);
		for (PlateOfferJson po : pos)
		{
			plateOffers.put(po.getRegNo(),po);					// just get latest
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

	public void updateProfile(ProfileJson profile) {
		try
		{
			BaseUser bu = services.getHome().getBaseUserDao().getByEmail(profile.getEmail());
			copyProfile(bu,profile);
			services.getHome().getBaseUserDao().update(bu);
		}
		catch (ValidatorException e2)
		{
			throw new RestServicesException(e2.getMessage());
		}
		catch (Exception e)
		{
			log.error(e);
			throw new RestServicesException("Could not register user - contact support");
		}
	}

	public void makeOffer(String buyerEmail, SendPlateOfferJson joffer) {
		double offer = 0;
		try
		{
			offer = Double.parseDouble(joffer.getOffer().replace(",",""));
			if (offer<=0)
				throw new RestServicesException("Invalid offer - please resubmit");
		}
		catch (Exception e)
		{
			throw new RestServicesException("Invalid offer - please resubmit");
		}
		try
		{
			Plate plate = services.getHome().getPlateDao().getById(joffer.getPlateId());
			PlateOffer plateOffer = new PlateOffer();
			plateOffer.setBuyerEmail(buyerEmail);
			plateOffer.setOffer(offer);
			plateOffer.setPlateSell(plate.getPlateSell());
			plateOffer.setOfferedOn((new GregorianCalendar()).getTime());
			plateOffer.setRegNo(plate.getRegNo());
			services.getHome().getPlateSellDao().storePlateOffer(plateOffer);
		}
		catch (Exception e)
		{
			log.error(e);
			throw new RestServicesException("Could not make offer - contact support");
		}
	}

	public void changeOfferStatus(String offerIdStr,PlateOfferStatusJson status) {
		Long offerId = 0L;
		try
		{
			offerId = Long.parseLong(offerIdStr);
			services.getHome().getPlateSellDao().setPlateOfferStatus(offerId,status);
		}
		catch (Exception e)
		{
			throw new RestServicesException("Invalid offerId - contact support");
		}
		
	}

	public void publishPlateProofOffer(MultipartFile file,String plateId)
	{
		long pid;
		try
		{
			pid = Long.parseLong(plateId);
		}
		catch (Exception e)
		{
			throw new RestServicesException("Error on upload - invalid plateid - contact support");
		}
		try
		{
			byte[] bytes = file.getBytes();
			services.getHome().getPlateSellDao().updatePlateSellProofOwner(bytes,pid);
		}
		catch (IOException e)
		{
			log.error(e.getMessage(),e);
			services.getHome().getPlateDao().delete(pid);
			throw new RestServicesException("Error on upload - please resubmit another file");
		}
	}
	
	public String publishPlate(PlatePublishJson platePublish,String email) {
		double price;
		try
		{
			price = Double.parseDouble(platePublish.getPrice().replace(",",""));
			if (price<=0)
				throw new RestServicesException("Invalid price - please resubmit");
		}
		catch (Exception e)
		{
			throw new RestServicesException("Invalid price - please resubmit");
		}
		alignParams(platePublish);
		if (platePublish.getPrefix().isEmpty())
			throw new RestServicesException("Missing prefix - please resubmit");
		if (platePublish.getNumber1().isEmpty())
			throw new RestServicesException("Missing number(s) - please resubmit");
		try
		{
			Plate plate = createPlate(platePublish,price);
			services.getHome().getPlateDao().store(plate);
			PlateSell ps = new PlateSell();
			ps.setPlate(plate);
			ps.setSellDate((new GregorianCalendar()).getTime());
			ps.setSellerEmail(email);
			services.getHome().getPlateSellDao().storePlateSell(ps);
			
			log.info("Stored : " + plate.getRegNo() + " - " + plate.getListPrice());
			return Long.toString(plate.getId());
		}
		catch (PersistenceDuplicateKeyException e)
		{
			log.warn(e.getMessage());
			throw new RestServicesException(e.getMessage());
		}
		catch (Exception e)
		{
			log.error(e.getMessage(),e);
			throw new RestServicesException("Unexpected error saving plate - contact support");
		}
			
		
	}

	private Plate createPlate(PlatePublishJson platePublish,double price) {
		Plate plate = new Plate();
		plate.setPrefix(platePublish.getPrefix());
		plate.setLetter1(platePublish.getLetter1());
		plate.setLetter2(platePublish.getLetter2());
		plate.setNumber1(platePublish.getNumber1());
		plate.setNumber2(platePublish.getNumber2());
		plate.setNumber3(platePublish.getNumber3());
		plate.setNumber4(platePublish.getNumber4());
		plate.setSuffix(platePublish.getSuffix());
		plate.setListPrice(price);
		plate.setSpecials();
		return plate;
	}
}
