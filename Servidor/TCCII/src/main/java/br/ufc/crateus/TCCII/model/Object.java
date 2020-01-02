package br.ufc.crateus.TCCII.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Object {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "object_sequence")
	@SequenceGenerator(name = "object_sequence", sequenceName = "object_seq")
	private int id;
	private String identification;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
}
