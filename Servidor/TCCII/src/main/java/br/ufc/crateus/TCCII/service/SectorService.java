package br.ufc.crateus.TCCII.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.crateus.TCCII.model.Sector;
import br.ufc.crateus.TCCII.repository.SectorRepository;

@Service
public class SectorService {

	@Autowired
	private SectorRepository repository;
	
	public Iterable<Sector> listSectors(){
		return repository.findAll();
	}
	
	public Sector addSector(Sector sector){
		return repository.save(sector);
	}
}
