package org.plate.rest.anon;

import org.plate.json.QueryOnDigitsParamsJson;
import org.plate.json.QueryOnPlateParamsJson;
import org.plate.json.ResultJson;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public interface RestAnonController {

	
	@RequestMapping(value = "/getSuccess")
	// PkfzResultJson contains message if success, message if fail
	public ResultJson getSuccess();
	
	@RequestMapping(value = "/getAllPlates")
	// PkfzResultJson contains List<PlateJson> if success, message if fail
	public ResultJson getAllPlates();
	
	@RequestMapping(value = "/getQueryParams")
	// PkfzResultJson contains QueryParamsJson if success, message if fail
	public ResultJson getQueryParams();
	
	@RequestMapping(value = "/queryPlate")
	// PkfzResultJson contains List<PlateJson> if success, message if fail
	public ResultJson queryPlate(@RequestBody() QueryOnPlateParamsJson params);
	
	@RequestMapping(value = "/queryDigits")
	// PkfzResultJson contains List<PlateJson> if success, message if fail
	public ResultJson queryDigits(@RequestBody() QueryOnDigitsParamsJson params);
	
}