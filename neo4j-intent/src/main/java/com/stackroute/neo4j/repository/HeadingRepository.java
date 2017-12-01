package com.stackroute.neo4j.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stackroute.neo4j.domain.Heading;
import com.stackroute.neo4j.domain.Indicator;
import com.stackroute.neo4j.domain.Level;


	@RepositoryRestResource(collectionResourceRel = "people", path = "level")
	public interface HeadingRepository extends PagingAndSortingRepository<Heading, Long> {

	public Heading findByName(String name);

	}