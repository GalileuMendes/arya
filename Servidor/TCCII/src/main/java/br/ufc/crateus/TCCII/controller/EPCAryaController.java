package br.ufc.crateus.TCCII.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.crateus.TCCII.model.EPC_Arya;
import br.ufc.crateus.TCCII.service.EPCAryaService;

@RestController
@RequestMapping("/api/epcarya")
public class EPCAryaController {

	@Autowired
	private EPCAryaService EPCAryaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public EPC_Arya addEPC(@RequestBody EPC_Arya epc){
		return EPCAryaService.saveEPCArya(epc);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<EPC_Arya> getEPCs(){
		return (ArrayList<EPC_Arya>) EPCAryaService.listEPCsArya();
	}
	
	@RequestMapping(value= "/{id}", method = RequestMethod.GET)
	public Optional<EPC_Arya> getEPCs(@PathVariable long id){
		return EPCAryaService.getEPCArya(id);
	}
}
