package br.ufc.crateus.TCCII.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import br.ufc.crateus.TCCII.model.EPC_Arya;

public interface EPCAryaRepository extends CrudRepository<EPC_Arya, Long>, QuerydslPredicateExecutor<EPC_Arya>{

}
