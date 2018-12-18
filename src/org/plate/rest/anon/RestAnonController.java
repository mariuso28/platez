package org.plate.rest.anon;

import org.plate.json.PlateParamsJson;
import org.plate.json.ProfileJson;
import org.plate.json.QueryOnDigitsParamsJson;
import org.plate.json.ResultJson;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public interface RestAnonController {

	
	@RequestMapping(value = "/getSuccess")
	// PkfzResultJson contains message if success, message if fail
	public ResultJson getSuccess();
	
	@RequestMapping(value = "/register")
	// PkfzResultJson contains message if success, message if fail
	public ResultJson register(@RequestBody() ProfileJson profile);
	
	@RequestMapping(value = "/getAllPlates")
	// PkfzResultJson contains List<PlateJson> if success, message if fail
	public ResultJson getAllPlates();
	
	@RequestMapping(value = "/getQueryParams")
	// PkfzResultJson contains QueryParamsJson if success, message if fail
	public ResultJson getQueryParams();
	
	@RequestMapping(value = "/queryPlate")
	// PkfzResultJson contains List<PlateJson> if success, message if fail
	public ResultJson queryPlate(@RequestBody() PlateParamsJson params);
	
	@RequestMapping(value = "/queryDigits")
	// PkfzResultJson contains List<PlateJson> if success, message if fail
	public ResultJson queryDigits(@RequestBody() QueryOnDigitsParamsJson params);
	
}