package br.ufc.crateus.TCCII.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.crateus.TCCII.repository.TypeRepository;
import br.ufc.crateus.TCCII.model.Type;

@Service
public class TypeService {

	@Autowired
	private TypeRepository repository;
	
	public Iterable<Type> listTypes() {
		return repository.findAll();
	}
	
	public Type saveType(Type type) {	
		return repository.save(type);
	}
}
