package br.ufc.crateus.TCCII.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TagRFID {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_sequence")
	@SequenceGenerator(name = "tag_sequence", sequenceName = "tag_seq")
	private int id;
	private String identificationTagRFID;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdentificationTagRFID() {
		return identificationTagRFID;
	}
	public void setIdentificationTagRFID(String identificationTagRFID) {
		this.identificationTagRFID = identificationTagRFID;
	}
}
