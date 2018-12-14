package org.plate.rest.punter;

import org.plate.json.ProfileJson;
import org.plate.json.ResultJson;
import org.plate.json.SendPlateOfferJson;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface RestPunterController {
	@RequestMapping(value = "/getPunter")
	// PkfzResultJson contains PunterJson if success, message if fail
	public ResultJson getPunter(OAuth2Authentication auth);
	
	@RequestMapping(value = "/updateProfile")
	// PkfzResultJson contains nothing if success, message if fail
	public ResultJson updateProfile(OAuth2Authentication auth,@RequestBody() ProfileJson profile);
	
	@RequestMapping(value = "/makeOffer")
	// PkfzResultJson contains nothing if success, message if fail
	public ResultJson makeOffer(OAuth2Authentication auth,@RequestBody() SendPlateOfferJson offer);
	
	@RequestMapping(value = "/cancelOffer")
	// PkfzResultJson contains nothing if success, message if fail
	public ResultJson cancelOffer(OAuth2Authentication auth,@RequestParam("offerId") String offerId);
	
	@RequestMapping(value = "/acceptOffer")
	// PkfzResultJson contains nothing if success, message if fail
	public ResultJson acceptOffer(OAuth2Authentication auth,@RequestParam("offerId") String offerId);
	
	@RequestMapping(value = "/rejectOffer")
	// PkfzResultJson contains nothing if success, message if fail
	public ResultJson rejectOffer(OAuth2Authentication auth,@RequestParam("offerId") String offerId);

}
