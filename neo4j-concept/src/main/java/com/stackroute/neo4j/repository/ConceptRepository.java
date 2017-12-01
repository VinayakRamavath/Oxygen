package com.stackroute.neo4j.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stackroute.neo4j.domain.Subconcept;
import com.stackroute.neo4j.domain.Concept2;


	@RepositoryRestResource(collectionResourceRel = "people", path = "level")
	public interface ConceptRepository extends PagingAndSortingRepository<Concept2, Long> {

	public Concept2 findByName(String name);

	}
	

