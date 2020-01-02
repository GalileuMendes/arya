package br.ufc.crateus.TCCII.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.crateus.TCCII.model.Type;
import br.ufc.crateus.TCCII.service.TypeService;

@RestController
@RequestMapping("/api/type")
public class TypeController {
	
	@Autowired
	private TypeService typeService;
	
	@RequestMapping(method = RequestMethod.GET)
    public ArrayList<Type> getTypes(){
        return (ArrayList<Type>) typeService.listTypes();
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public Type addType(@RequestBody Type type) {
		return typeService.saveType(type);
	}
}
