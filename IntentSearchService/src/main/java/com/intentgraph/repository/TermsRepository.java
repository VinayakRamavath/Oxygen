package com.intentgraph.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.intentgraph.domain.Terms;

public interface TermsRepository extends PagingAndSortingRepository<Terms,Long> {
	public Terms findByName(String name);

}