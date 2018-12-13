package org.plate.rest.punter;

import org.plate.json.ResultJson;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;

public interface RestPunterController {
	@RequestMapping(value = "/getPunter")
	// PkfzResultJson contains PunterJson if success, message if fail
	public ResultJson getPunter(OAuth2Authentication auth);

}
