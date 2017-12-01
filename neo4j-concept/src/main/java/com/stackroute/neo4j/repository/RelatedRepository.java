package com.stackroute.neo4j.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stackroute.neo4j.domain.Related;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface RelatedRepository extends PagingAndSortingRepository<Related, Long> {

	

}


