package br.ufc.crateus.TCCII.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.crateus.TCCII.model.Sector;
import br.ufc.crateus.TCCII.service.SectorService;

@RestController
@RequestMapping("/api/sector")
public class SectorController {

	@Autowired
	private SectorService sectorService;
	
	@RequestMapping(method = RequestMethod.GET)
    public ArrayList<Sector> getSectors(){
        return (ArrayList<Sector>) sectorService.listSectors();
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public Sector addSector(@RequestBody Sector sector) {
		return sectorService.addSector(sector);
	}
}
