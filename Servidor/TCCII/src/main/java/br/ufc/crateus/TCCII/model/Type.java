package br.ufc.crateus.TCCII.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Type {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_sequence")
	@SequenceGenerator(name = "type_sequence", sequenceName = "type_seq")
	private int id;
	private String name;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
