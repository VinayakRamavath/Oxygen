package com.stackroute.neo4j.repository;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stackroute.neo4j.domain.Subconcept;
import com.stackroute.neo4j.domain.UrlRelation;
import com.stackroute.neo4j.domain.Concept2;


	@RepositoryRestResource(collectionResourceRel = "people", path = "level")
	public interface UrlRelation1Repository extends Repository<UrlRelation, Long> {

		public List<UrlRelation> findByName(String name);

	}