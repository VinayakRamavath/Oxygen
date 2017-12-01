package com.stackroute.github.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.github.domain.DomainConcept;
import com.stackroute.github.domain.SearchResultsModel;

@Repository
public interface ApiRepository extends CrudRepository<DomainConcept,Long> {

	

}
