package com.intentgraph.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.intentgraph.domain.Query;


public interface QueryRepository extends PagingAndSortingRepository<Query, Long> {

	public Query findByName(String name);

	}