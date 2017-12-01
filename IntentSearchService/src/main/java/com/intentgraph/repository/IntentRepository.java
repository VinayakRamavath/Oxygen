package com.intentgraph.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.intentgraph.domain.IntentOf;
import com.intentgraph.domain.Terms;

public interface IntentRepository extends PagingAndSortingRepository<IntentOf, Long> {
	
} 