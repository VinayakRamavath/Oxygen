package com.stackroute.neo4j.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stackroute.neo4j.domain.Indicator;
import com.stackroute.neo4j.domain.Level;


	@RepositoryRestResource(collectionResourceRel = "people", path = "level")
	public interface LevelRepository extends PagingAndSortingRepository<Level, Long> {

	public Level findByName(String name);

	}
	

