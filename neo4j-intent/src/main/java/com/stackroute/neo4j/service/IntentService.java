package com.stackroute.neo4j.service;


import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.neo4j.domain.CounterIndicator;
import com.stackroute.neo4j.domain.Heading;
import com.stackroute.neo4j.domain.Intent;
import com.stackroute.neo4j.domain.Level;
import com.stackroute.neo4j.domain.Terms;
import com.stackroute.neo4j.repository.CounterIndicatorRepository;
import com.stackroute.neo4j.repository.HeadingRepository;
import com.stackroute.neo4j.repository.IntentRepository;
import com.stackroute.neo4j.repository.LevelRepository;


@Service
public class IntentService {

	@Autowired
	IntentRepository intentRepository;
	
	@Autowired
	HeadingRepository headingRepository;


	@Transactional(readOnly = true)
	public  Iterable<Intent>  graph_intent(int limit) {
		 Iterable<Intent> result = intentRepository.findAll();
		return result;
	}
	
	@Transactional(readOnly = true)
	public String  postnode(Intent intent) {
		Intent result = intentRepository.save(intent);
		return "node saved";
	}
	
	@Transactional(readOnly = true)
	public Heading  findlevelbyname(String name) {
		Heading result = headingRepository.findByName(name);
		return result;
	}
	
	
}
