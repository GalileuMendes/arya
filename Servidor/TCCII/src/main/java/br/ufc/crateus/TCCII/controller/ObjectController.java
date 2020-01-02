package br.ufc.crateus.TCCII.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.crateus.TCCII.model.Object;
import br.ufc.crateus.TCCII.service.ObjectService;

@RestController
@RequestMapping("/api/object")
public class ObjectController {
	
	@Autowired
	private ObjectService objectService;

	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<Object> getObjects(){
		return (ArrayList<Object>) objectService.listObjects();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object addObject(@RequestBody Object object){
		return (Object) objectService.addObject(object);
	}
}
