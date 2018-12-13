package org.plate.rest.punter;

import org.apache.log4j.Logger;
import org.plate.json.PunterJson;
import org.plate.json.ResultJson;
import org.plate.rest.services.RestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
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
		try
		{
			PunterJson punter = restServices.getPunter(email);
			result.success(punter);
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
}