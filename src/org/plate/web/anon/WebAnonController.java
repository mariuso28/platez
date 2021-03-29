package org.plate.web.anon;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/web/anon")

@SessionAttributes({ "errMsg" } )

public class WebAnonController {
	private static Logger log = Logger.getLogger(WebAnonController.class);
	
	@RequestMapping(value = "/getSuccess", method = RequestMethod.GET)
	public String getSuccess() {
			
		log.info("Received request to test");
			
		return "xxx";
	}
	
	@RequestMapping(value = "/getAllPlates", method = RequestMethod.GET)
	public String getAllPlates() {
			
		log.info("Received request to getAllPlates");
			
		return "allPlates";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
			
		log.info("Received request to register");
			
		return "register";
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin() {
			
		log.info("Received request to signin");
			
		return "signin";
	}
	
	@RequestMapping(value = "/getAgent", method = RequestMethod.GET)
	public String getAgent() {
			
		log.info("Received getAgent");
			
		return "agent";
	}
	
	@RequestMapping(value = "/goAgentHome", method = RequestMethod.GET)
	public String goAgentHome() {
			
		log.info("Received goAgentHome");
			
		return "agent";
	}
	
	@RequestMapping(value = "/getPunter", method = RequestMethod.GET)
	public String getPunter() {
			
		log.info("Received getPunter");
			
		return "punter";
	}
	
	@RequestMapping(value = "/goPunterHome", method = RequestMethod.GET)
	public String goPunterHome() {
			
		log.info("Received goPunterHome");
			
		return "punter";
	}
	
	@RequestMapping(value = "/invalidSession", method = RequestMethod.GET)
	public String invalidSession(ModelMap model) {
		
		log.info("Received invalidSession");
		model.addAttribute("errMsg", "Invalid Session");
		return "error";
	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(ModelMap model) {
		
		log.info("Received accessDenied");
		model.addAttribute("errMsg", "Access Denied");
		return "error";
	}
}
