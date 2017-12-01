package com.stackroute.neo4j.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.stackroute.neo4j.domain.Subconcept;
import com.stackroute.neo4j.domain.Concept2;
import com.stackroute.neo4j.repository.SubconceptRepository;
import com.stackroute.neo4j.repository.ConceptRepository;


@Service
public class SubconceptService {

	@Autowired
	SubconceptRepository subconceptRepository;
	
	@Autowired
	ConceptRepository conceptRepository;


	@Transactional(readOnly = true)
	public  Iterable<Subconcept>  graph_terms(int limit) {
		 Iterable<Subconcept> result = subconceptRepository.findAll();
		return result;
	}
	

	
	@Transactional(readOnly = true)
	public Subconcept  postnode(Subconcept subconcept) {
		Subconcept result = subconceptRepository.save(subconcept);
		return subconcept;
	}
	
	
	
	@Transactional(readOnly = true)
	public Concept2  findlevelbyname(String name) {
		Concept2 result = conceptRepository.findByName(name);
		return result;
	}


	
}
