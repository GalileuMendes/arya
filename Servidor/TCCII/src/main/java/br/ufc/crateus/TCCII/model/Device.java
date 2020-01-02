package br.ufc.crateus.TCCII.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Device {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "device_sequence")
	@SequenceGenerator(name = "device_sequence", sequenceName = "device_seq")
	private long id;
	private String name;
	private String mac;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}	
}
