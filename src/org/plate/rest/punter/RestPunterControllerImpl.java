package org.plate.rest.punter;

import org.apache.log4j.Logger;
import org.plate.json.PlateOfferStatusJson;
import org.plate.json.PlatePublishJson;
import org.plate.json.ProfileJson;
import org.plate.json.PunterJson;
import org.plate.json.ResultJson;
import org.plate.json.SendPlateOfferJson;
import org.plate.rest.services.RestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/punter")
public class RestPunterControllerImpl implements RestPunterController{
	private static Logger log = Logger.getLogger(RestPunterControllerImpl.class);
	@Autowired
	private RestServices restServices;
	
	@Override
	@RequestMapping(value = "/getPunter")
	// PkfzResultJson contains punterJson if success, message if fail
	public ResultJson getPunter(OAuth2Authentication auth)
	{
		String email = ((User)auth.getPrincipal()).getUsername();
		log.info("Received getPunter for : " + email);
		
		ResultJson result = new ResultJson();
		
		PunterJson punter = getPunter(email,result);
		if (punter!=null)
			result.success(punter);
		
		return result;
	}
	
	@Override
	@RequestMapping(value = "/updateProfile")
	// PkfzResultJson contains nothing if success, message if fail
	public ResultJson updateProfile(OAuth2Authentication auth,@RequestBody() ProfileJson profile)
	{
		String email = ((User)auth.getPrincipal()).getUsername();
		log.info("Received updateProfile for : " + email);
		
		ResultJson result = new ResultJson();
		PunterJson punter = getPunter(email,result);
		if (punter==null)
			return result;
		try
		{
			restServices.updateProfile(profile);
			result.success();
		}
		catch (Exception e)
		{
			log.error(e.getMessage(),e);
			if (e.getMessage()!=null)
				result.fail(e.getMessage());
			else
				result.fail(e.toString());
		}
		
		return result;
	}
	
	@RequestMapping(value = "/makeOffer")
	// PkfzResultJson contains nothing if success, message if fail
	public ResultJson makeOffer(OAuth2Authentication auth,@RequestBody() SendPlateOfferJson offer)
	{
		String email = ((User)auth.getPrincipal()).getUsername();
		log.info("Received makeOffer for : " + email);
		
		ResultJson result = new ResultJson();
		PunterJson punter = getPunter(email,result);
		if (punter==null)
			return result;
		try
		{
			restServices.makeOffer(email,offer);
			result.success();
		}
		catch (Exception e)
		{
			log.error(e.getMessage(),e);
			if (e.getMessage()!=null)
				result.fail(e.getMessage());
			else
				result.fail(e.toString());
		}
		
		return result;
	}
	
	@RequestMapping(value = "/cancelOffer")
	// PkfzResultJson contains nothing if success, message if fail
	public ResultJson cancelOffer(OAuth2Authentication auth,@RequestParam("offerId") String offerId)
	{
		String email = ((User)auth.getPrincipal()).getUsername();
		log.info("Received cancelOffer for : " + email);
		
		return changeOfferStatus(email,offerId,PlateOfferStatusJson.CANCELLED);
	}
	
	@RequestMapping(value = "/acceptOffer")
	// PkfzResultJson contains nothing if success, message if fail
	public ResultJson acceptOffer(OAuth2Authentication auth,@RequestParam("offerId") String offerId)
	{
		String email = ((User)auth.getPrincipal()).getUsername();
		log.info("Received acceptOffer for : " + email);
		
		return changeOfferStatus(email,offerId,PlateOfferStatusJson.ACCEPTED);
	}
	
	@RequestMapping(value = "/rejectOffer")
	// PkfzResultJson contains nothing if success, message if fail
	public ResultJson rejectOffer(OAuth2Authentication auth,@RequestParam("offerId") String offerId)
	{
		String email = ((User)auth.getPrincipal()).getUsername();
		log.info("Received acceptOffer for : " + email);
		
		return changeOfferStatus(email,offerId,PlateOfferStatusJson.REJECTED);
	}
	
	private ResultJson changeOfferStatus(String email,String offerId,PlateOfferStatusJson status)
	{
		ResultJson result = new ResultJson();
		PunterJson punter = getPunter(email,result);
		if (punter==null)
			return result;
		
		try
		{
			restServices.changeOfferStatus(offerId,status);
			result.success();
		}
		catch (Exception e)
		{
			log.error(e.getMessage(),e);
			if (e.getMessage()!=null)
				result.fail(e.getMessage());
			else
				result.fail(e.toString());
		}
		return result;
	}
	
	@RequestMapping(value = "/publishPlate")
	// PkfzResultJson contains nothing if success, message if fail
	public ResultJson publishPlate(OAuth2Authentication auth,@RequestBody() PlatePublishJson platePublish)
	{
		String email = ((User)auth.getPrincipal()).getUsername();
		ResultJson result = new ResultJson();
		PunterJson punter = getPunter(email,result);
		if (punter==null)
			return result;
		
		try
		{
			restServices.publishPlate(platePublish, punter.getProfile().getEmail());
			result.success();
		}
		catch (Exception e)
		{
			log.error(e.getMessage(),e);
			if (e.getMessage()!=null)
				result.fail(e.getMessage());
			else
				result.fail(e.toString());
		}
		return result;
	}
	
	private PunterJson getPunter(String email,ResultJson result)
	{
		PunterJson punter = null;
		try {
			punter = restServices.getPunter(email);
		} catch (Exception e) {
			log.error("Punter : " + email + " not found");
			result.fail("Punter : " + email + " not found");	
		}
		return punter;
	}

}