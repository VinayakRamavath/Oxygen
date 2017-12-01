package com.intentgraph.repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.intentgraph.domain.Level;
import com.intentgraph.domain.Terms;

public interface LevelRepository extends PagingAndSortingRepository<Terms,Long> {
	public Level findByName(String name);

}
