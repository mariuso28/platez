package org.plate.rest.agent;

import org.plate.json.ProfileJson;
import org.plate.json.ResultJson;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public interface RestAgentController {
	
	@RequestMapping(value = "/getAgent")
	// PkfzResultJson contains agentJson if success, message if fail
	public ResultJson getAgent(OAuth2Authentication auth);
	
	@RequestMapping(value = "/updateProfile")
	// PkfzResultJson contains nothing if success, message if fail
	public ResultJson updateProfile(OAuth2Authentication auth,@RequestBody() ProfileJson profile);
	
}