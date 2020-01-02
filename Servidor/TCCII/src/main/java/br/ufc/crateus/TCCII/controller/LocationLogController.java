package br.ufc.crateus.TCCII.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.crateus.TCCII.model.LocationLog;
import br.ufc.crateus.TCCII.service.LocationLogService;

@RestController
@RequestMapping("/api/location")
public class LocationLogController {
	
	@Autowired
	private LocationLogService locationLogService;
	
	@RequestMapping(method = RequestMethod.POST)
	public LocationLog addlocationLog(@RequestBody LocationLog locationLog){
		return locationLogService.saveLocationLog(locationLog);
	}
	
	@RequestMapping(value = "/{idDevice}/epc", method = RequestMethod.POST)
	public LocationLog addlocationLog(@PathVariable long idDevice, @RequestBody String epc){
		return locationLogService.saveLocationLogEPC(idDevice, epc);
	}

	@RequestMapping(value = "/{id}/device", method = RequestMethod.GET)
    public ArrayList<LocationLog> getLocationsLogDevice(@PathVariable long id){
        return (ArrayList<LocationLog>) locationLogService.listLocationsLogIdDevice(id);
    }
	
	@RequestMapping(method = RequestMethod.GET)
    public ArrayList<LocationLog> getLocationsLog(@RequestParam (required = false) Long deviceID, 
    		@RequestParam (required = false) Long epcID, @RequestParam (required = true) String startDate, 
    			@RequestParam (required = true) String endDate){
        
		return (ArrayList<LocationLog>) locationLogService.listLocationLogCustumer(deviceID, epcID, startDate, endDate);
    }
}
