package br.ufc.crateus.TCCII.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import br.ufc.crateus.TCCII.model.LocationLog;

public interface LocationLogRepository extends CrudRepository<LocationLog, Long>, QuerydslPredicateExecutor<LocationLog>{

}
