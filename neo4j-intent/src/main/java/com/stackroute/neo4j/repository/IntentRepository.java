package com.stackroute.neo4j.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stackroute.neo4j.domain.Indicator;
import com.stackroute.neo4j.domain.Intent;

	@RepositoryRestResource(collectionResourceRel = "people", path = "people")
	public interface IntentRepository extends PagingAndSortingRepository<Intent, Long> {

	}
