package com.stackroute.neo4j.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stackroute.neo4j.domain.Concept2;
import com.stackroute.neo4j.domain.Subconcept;
import com.stackroute.neo4j.domain.UrlFromGoogle;

@RepositoryRestResource(collectionResourceRel = "people", path = "level")
public interface UrlFromGoogleRepository extends PagingAndSortingRepository<UrlFromGoogle, Long> {

public UrlFromGoogle findByName(String name);

}