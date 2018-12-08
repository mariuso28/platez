package org.plate.rest.anon;

import java.util.List;

import org.plate.json.PlateJson;
import org.plate.json.ResultJson;
import org.plate.rest.services.RestServices;
import org.plate.rest.services.RestServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/anon")
public class RestAnonControllerImpl implements RestAnonController {

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
}
