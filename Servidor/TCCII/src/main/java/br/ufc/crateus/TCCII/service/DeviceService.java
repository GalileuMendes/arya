package br.ufc.crateus.TCCII.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

import br.ufc.crateus.TCCII.model.Device;
import br.ufc.crateus.TCCII.model.QDevice;
import br.ufc.crateus.TCCII.repository.DeviceRepository;

@Service
public class DeviceService{
	
	@Autowired
	private DeviceRepository repository;
	
	QDevice device = QDevice.device;

	public Iterable<Device> listDevices() {
		return repository.findAll();
	}
	
	public Optional<Device> getDevice(long id) {
		return repository.findById(id);
	}
	
	public Device saveDevice(Device device) {	
		return repository.save(device);
	}

	public Iterable<Device> getDeviceMac(String mac) {
		
		BooleanExpression query = Expressions.asBoolean(true).isTrue();
		
		BooleanExpression macIs = device.mac.eq(mac);
		query = query.and(macIs);
		
		return repository.findAll(query);
	}
}
