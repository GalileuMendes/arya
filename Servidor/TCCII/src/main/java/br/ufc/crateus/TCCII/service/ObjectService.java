package br.ufc.crateus.TCCII.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.crateus.TCCII.repository.ObjectRepository;
import br.ufc.crateus.TCCII.model.Object;

@Service
public class ObjectService {

	@Autowired
	private ObjectRepository repository;
	
	public Iterable<Object> listObjects(){
		return repository.findAll();
	}
	
	public Object addObject(Object object) {
		return repository.save(object);
	}
}
