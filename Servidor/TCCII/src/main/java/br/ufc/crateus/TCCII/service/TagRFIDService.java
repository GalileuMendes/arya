package br.ufc.crateus.TCCII.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.crateus.TCCII.repository.TagRFIDRepository;
import br.ufc.crateus.TCCII.model.TagRFID;

@Service
public class TagRFIDService {

	@Autowired
	private TagRFIDRepository repository;
	
	public Iterable<TagRFID> listTags(){
		return repository.findAll();
	}
	
	public TagRFID addTag(TagRFID tag) {
		return repository.save(tag);
	}
}
