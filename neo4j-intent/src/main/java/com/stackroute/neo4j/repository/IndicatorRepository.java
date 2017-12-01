package com.stackroute.neo4j.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stackroute.neo4j.domain.Indicator;
import com.stackroute.neo4j.domain.Terms;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface IndicatorRepository extends PagingAndSortingRepository<Indicator, Long> {

	@Query("MATCH (m:Terms)-[r:indicator_of]->(a:Level) RETURN m,r,a")
	Collection<Terms> graph_terms(@Param("limit") int limit);

}


