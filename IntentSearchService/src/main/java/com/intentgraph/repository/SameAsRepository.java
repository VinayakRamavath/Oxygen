package com.intentgraph.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.intentgraph.domain.SameAs;

public interface SameAsRepository extends PagingAndSortingRepository<SameAs, Long> {

	public SameAs findByName(String name);

} 