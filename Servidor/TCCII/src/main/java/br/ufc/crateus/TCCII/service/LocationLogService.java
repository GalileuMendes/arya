package br.ufc.crateus.TCCII.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

import br.ufc.crateus.TCCII.model.Device;
import br.ufc.crateus.TCCII.model.EPC_Arya;
import br.ufc.crateus.TCCII.model.LocationLog;
import br.ufc.crateus.TCCII.model.QEPC_Arya;
import br.ufc.crateus.TCCII.model.QLocationLog;
import br.ufc.crateus.TCCII.repository.LocationLogRepository;

@Service
public class LocationLogService {

	@Autowired
	private LocationLogRepository repository;
	
	@Autowired
	private EPCAryaService epcService;
	
	@Autowired
	private DeviceService deviceService;
	
	QLocationLog locationLog = QLocationLog.locationLog;
	QEPC_Arya epcArya = QEPC_Arya.ePC_Arya;
	
	public Iterable<LocationLog> listLocationLogs(){
		return repository.findAll();
	}
	
	public Optional<LocationLog> listLocationLogId(long idLog){
		return repository.findById(idLog);
	}
	
	public Iterable<LocationLog> listLocationsLogIdDevice(long idDevice){
		
		BooleanExpression query = Expressions.asBoolean(true).isTrue();
		
		BooleanExpression deviceIs = locationLog.device.id.eq(idDevice);
		query = query.and(deviceIs);
		
		return repository.findAll(query);
	}
	
	public Iterable<LocationLog> listLocationLogCustumer(Long deviceID, Long epcID, String startDate, String endDate){
		
		LocalDateTime initDate = LocalDateTime.parse(startDate);
		LocalDateTime finalDate = LocalDateTime.parse(endDate);
		
		BooleanExpression query = Expressions.asBoolean(true).isTrue();
		
		if(!IsNull(deviceID)) {
			BooleanExpression deviceIs = locationLog.device.id.eq(deviceID);
			query = query.and(deviceIs);
		}
		
		if(!IsNull(epcID)) {
			BooleanExpression epcIs = locationLog.epc.id.eq(epcID);
			query = query.and(epcIs);
		}
		
		BooleanExpression betweenDate = locationLog.pickupMoment.between(initDate, finalDate);
		query = query.and(betweenDate);
		
		return repository.findAll(query);
	}
	
	public LocationLog saveLocationLog(LocationLog log){
		
		log.setPickupMoment(LocalDateTime.now());
		return repository.save(log);
	}
	
	public LocationLog saveLocationLogEPC(long idDevice, String epc) {

		Optional<EPC_Arya> epcFinal = epcService.getEPCArya(epc);
		Optional<Device> deviceFinal = deviceService.getDevice(idDevice);
		
		LocationLog locationFinal = new LocationLog();
		
		locationFinal.setDevice(deviceFinal.get());
		locationFinal.setEpc(epcFinal.get());
		locationFinal.setPickupMoment(LocalDateTime.now());
		
		return repository.save(locationFinal);
	}
	
	private boolean IsNull(Object object) {
		if(object == null)
			return true;
		return false;
	}
}
