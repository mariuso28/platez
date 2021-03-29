package org.plate.rest.agent;

import org.apache.log4j.Logger;
import org.plate.json.AgentJson;
import org.plate.json.ProfileJson;
import org.plate.json.ResultJson;
import org.plate.rest.services.RestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agent")
public class RestAgentControllerImpl implements RestAgentController{
	private static Logger log = Logger.getLogger(RestAgentControllerImpl.class);
	@Autowired
	private RestServices restServices;
	
	
	@Override
	@RequestMapping(value = "/getAgent")
	// PkfzResultJson contains agentJson if success, message if fail
	public ResultJson getAgent(OAuth2Authentication auth)
	{
		String email = ((User)auth.getPrincipal()).getUsername();
		log.info("Received getAgent for : " + email);
		
		ResultJson result = new ResultJson();
		
		AgentJson agent = getAgent(email,result);
		if (agent!=null)
			result.success(agent);
		
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
		AgentJson agent = getAgent(email,result);
		if (agent==null)
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
	
	private AgentJson getAgent(String email,ResultJson result)
	{
		AgentJson agent = null;
		try {
			agent = restServices.getAgent(email);
		} catch (Exception e) {
			log.error("Agent : " + email + " not found");
			result.fail("Agent : " + email + " not found");	
		}
		return agent;
	}

}