package br.ufc.crateus.TCCII.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.crateus.TCCII.model.TagRFID;
import br.ufc.crateus.TCCII.service.TagRFIDService;

@RestController
@RequestMapping("/api/tagrfid")
public class TagRFIDController {
	
	@Autowired
	private TagRFIDService tagRFIDService;
	
	@RequestMapping(method = RequestMethod.GET)
    public ArrayList<TagRFID> getTagsRFID(){
        return (ArrayList<TagRFID>) tagRFIDService.listTags();
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public TagRFID addType(@RequestBody TagRFID tagRFID) {
		return tagRFIDService.addTag(tagRFID);
	}
}
