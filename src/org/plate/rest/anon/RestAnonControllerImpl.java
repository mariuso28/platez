package org.plate.rest.anon;

import java.util.List;

import org.apache.log4j.Logger;
import org.plate.json.PlateJson;
import org.plate.json.PlateParamsJson;
import org.plate.json.ProfileJson;
import org.plate.json.QueryOnDigitsParamsJson;
import org.plate.json.QueryParamsJson;
import org.plate.json.ResultJson;
import org.plate.rest.services.RestServices;
import org.plate.rest.services.RestServicesException;
import org.plate.user.BaseUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/anon")
public class RestAnonControllerImpl implements RestAnonController {
	private static final Logger log = Logger.getLogger(RestAnonControllerImpl.class);
	
	@Autowired
	RestServices restServices;
	
	@Override
	@RequestMapping(value = "/getSuccess")
	// PkfzResultJson contains message if success, message if fail
	public ResultJson getSuccess()
	{
		ResultJson result = new ResultJson();
		result.success("SUCCESS");
		return result;
	}
	
	@Override
	@RequestMapping(value = "/register")
	// PkfzResultJson contains message if success, message if fail
	public ResultJson register(@RequestBody() ProfileJson profile)
	{
		log.info("Doing registration for : " + profile);
		ResultJson result = new ResultJson();
		try
		{
			restServices.register(profile,BaseUser.ROLE_PUNTER);
			result.success("User : " + profile.getEmail() + " successfully registered - please check email and follow intructions.");
		}
		catch (RestServicesException e)
		{
			log.error("Registration failed : " + e.getMessage());
			result.fail(e.getMessage());
		}
		return result;
	}
	
	@Override
	@RequestMapping(value = "/getAllPlates")
	// PkfzResultJson contains List<PlateJson> if success, message if fail
	public ResultJson getAllPlates()
	{
		ResultJson result = new ResultJson();
		try
		{
			List<PlateJson> pjs = restServices.getAllPlates();
			result.success(pjs);
		}
		catch (RestServicesException e)
		{
			result.fail(e.getMessage());
		}
		return result;
	}

	@Override
	public ResultJson getQueryParams() {
		ResultJson result = new ResultJson();
		try
		{
			QueryParamsJson qp = restServices.getQueryParams();
			result.success(qp);
		}
		catch (RestServicesException e)
		{
			result.fail(e.getMessage());
		}
		return result;
	}

	@Override
	@RequestMapping(value = "/queryPlate")
	// PkfzResultJson contains List<PlateJson> if success, message if fail
	public ResultJson queryPlate(@RequestBody() PlateParamsJson params) {
		ResultJson result = new ResultJson();
		log.info("in  queryPlate with : " + params);
		try
		{
			List<PlateJson> pjs = restServices.queryPlate(params);
			result.success(pjs);
		}
		catch (RestServicesException e)
		{
			result.fail(e.getMessage());
		}
		return result;
	}
	
	@Override
	@RequestMapping(value = "/queryDigits")
	// PkfzResultJson contains List<PlateJson> if success, message if fail
	public ResultJson queryDigits(@RequestBody() QueryOnDigitsParamsJson params) {
		ResultJson result = new ResultJson();
		log.info("in queryDigits with : " + params);
		try
		{
			List<PlateJson> pjs = restServices.queryDigits(params);
			result.success(pjs);
		}
		catch (RestServicesException e)
		{
			result.fail(e.getMessage());
		}
		return result;
	}
	
	
}
