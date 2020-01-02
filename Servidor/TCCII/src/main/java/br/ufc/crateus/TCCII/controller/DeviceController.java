package br.ufc.crateus.TCCII.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.crateus.TCCII.model.Device;
import br.ufc.crateus.TCCII.service.DeviceService;

@RestController
@RequestMapping("/api/device")
public class DeviceController {
	
	@Autowired
	DeviceService deviceService;

	@RequestMapping(method = RequestMethod.GET)
    public ArrayList<Device> getDevices(){
        return (ArrayList<Device>) deviceService.listDevices();
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public Device addDevice(@RequestBody Device device){	    
		return deviceService.saveDevice(device);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Device> getDevice(@PathVariable long id){
        return deviceService.getDevice((int) id);
    }
	
	@RequestMapping(value = "/mac", method = RequestMethod.GET)
    public ArrayList<Device> getDevice(@RequestParam String mac){
        return (ArrayList<Device>) deviceService.getDeviceMac(mac);
    }
}
