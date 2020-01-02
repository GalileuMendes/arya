package br.ufc.crateus.TCCII.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class LocationLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_sequence")
	@SequenceGenerator(name = "log_sequence", sequenceName = "log_sequence")
	private long id;
	@ManyToOne
	private Device device;
	@ManyToOne
	private EPC_Arya epc;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime pickupMoment;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
	public LocalDateTime getPickupMoment() {
		return pickupMoment;
	}
	public void setPickupMoment(LocalDateTime pickupMoment) {
		this.pickupMoment = pickupMoment;
	}
	public EPC_Arya getEpc() {
		return epc;
	}
	public void setEpc(EPC_Arya epc) {
		this.epc = epc;
	}
}
