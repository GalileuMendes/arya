package br.ufc.crateus.TCCII.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class EPC_Arya {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "epc_sequence")
	@SequenceGenerator(name = "epc_sequence", sequenceName = "epc_seq")
	private long id;
	@ManyToOne
	private Type type;
	@ManyToOne
	private Sector sector;
	@ManyToOne
	private Object objectId;
	@ManyToOne
	private TagRFID tagRFID;
	private String epcArya;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Object getObjectId() {
		return objectId;
	}
	public void setObjectId(Object objectId) {
		this.objectId = objectId;
	}
	public TagRFID getTagRFID() {
		return tagRFID;
	}
	public void setTagRFID(TagRFID tagRFID) {
		this.tagRFID = tagRFID;
	}
	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	public String getEpcArya() {
		return epcArya;
	}
	public void setEpcArya(String epcArya) {
		this.epcArya = epcArya;
	}
}
