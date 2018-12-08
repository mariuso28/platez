package org.plate.web.anon;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/web/anon")

public class AnonController {
	private static Logger log = Logger.getLogger(AnonController.class);
	
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
}
