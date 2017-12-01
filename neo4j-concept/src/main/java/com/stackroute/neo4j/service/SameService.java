package com.stackroute.neo4j.service;


import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.neo4j.domain.Subconcept;
import com.stackroute.neo4j.domain.Concept2;
import com.stackroute.neo4j.domain.Same;
import com.stackroute.neo4j.repository.ConceptRepository;
import com.stackroute.neo4j.repository.SameRepository;


@Service
public class SameService {

	@Autowired
	SameRepository sameRepository;
	
	@Autowired
	ConceptRepository conceptRepository;


	@Transactional(readOnly = true)
	public  Iterable<Same>  graph_terms(int limit) {
		 Iterable<Same> result = sameRepository.findAll();
		return result;
	}
	

	
	@Transactional(readOnly = true)
	public Same  postnode(Same same) {
		Same result = sameRepository.save(same);
		return same;
	}
	
	
	
	@Transactional(readOnly = true)
	public Concept2  findlevelbyname(String name) {
		Concept2 result = conceptRepository.findByName(name);
		return result;
	}


	
}
