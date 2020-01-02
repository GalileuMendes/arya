package br.ufc.crateus.TCCII.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

import br.ufc.crateus.TCCII.model.EPC_Arya;
import br.ufc.crateus.TCCII.model.Object;
import br.ufc.crateus.TCCII.model.QEPC_Arya;
import br.ufc.crateus.TCCII.model.Sector;
import br.ufc.crateus.TCCII.model.TagRFID;
import br.ufc.crateus.TCCII.model.Type;
import br.ufc.crateus.TCCII.repository.EPCAryaRepository;

@Service
public class EPCAryaService {

	@Autowired
	private EPCAryaRepository repository;
	
	QEPC_Arya epcarya = QEPC_Arya.ePC_Arya;
	
	public Iterable<EPC_Arya> listEPCsArya() {
		return repository.findAll();
	}
	
	public Optional<EPC_Arya> getEPCArya(long id) {
		return repository.findById(id);
	}
	
	public Optional<EPC_Arya> getEPCArya(String epc) {
		
		BooleanExpression query = Expressions.asBoolean(true).isTrue();
		
		System.out.println(epc);
		
		BooleanExpression epcIs = epcarya.epcArya.eq(epc);
		query = query.and(epcIs);
		
		return repository.findOne(query);
	}
	
	public EPC_Arya saveEPCArya(EPC_Arya epc) {
		epc.setEpcArya(generatedEPC(1, epc.getType(), epc.getSector(), epc.getObjectId(), epc.getTagRFID()));
		return repository.save(epc);
	}
	
	private String generatedEPC(int version, Type type, Sector sector, Object objectId, TagRFID tagRFID) {
		
		String newObjectIdBinary =  transforminBinaryString(Long.toBinaryString(objectId.getId()), 32);
		String newTagRFIDBinary = transforminBinaryString(Long.toBinaryString(tagRFID.getId()), 32);
		String newSectorBinary = transforminBinaryString(Long.toBinaryString(sector.getId()), 12);
		String newTypeBinary = transforminBinaryString(Long.toBinaryString(type.getId()), 12);
		String newVersionBinary = transforminBinaryString(Integer.toBinaryString(version), 8);
		
		return newVersionBinary + newTypeBinary + newSectorBinary + newObjectIdBinary + newTagRFIDBinary;
	}
	
	private String transforminBinaryString(String binary, int selector) {
		
		String result = "";
		
		if (binary.length() < selector) {
			int total = selector - binary.length();
			  
			for (int i = 0; i < total; i++) {
				result = result + "0";
			}
			
			return result + binary;
		}	
		return null;
	}
}
