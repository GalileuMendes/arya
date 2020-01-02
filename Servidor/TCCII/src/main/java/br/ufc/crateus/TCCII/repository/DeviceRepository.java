package br.ufc.crateus.TCCII.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import br.ufc.crateus.TCCII.model.Device;

public interface DeviceRepository extends CrudRepository<Device, Long>, QuerydslPredicateExecutor<Device>{

}
