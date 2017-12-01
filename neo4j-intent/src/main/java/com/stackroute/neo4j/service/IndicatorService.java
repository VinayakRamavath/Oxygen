package com.stackroute.neo4j.service;


import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.neo4j.domain.CounterIndicator;
import com.stackroute.neo4j.domain.Indicator;
import com.stackroute.neo4j.domain.Level;
import com.stackroute.neo4j.domain.Terms;
import com.stackroute.neo4j.repository.CounterIndicatorRepository;
import com.stackroute.neo4j.repository.IndicatorRepository;
import com.stackroute.neo4j.repository.LevelRepository;


@Service
public class IndicatorService {

	@Autowired
	IndicatorRepository indicatorRepository;
	
	@Autowired
	LevelRepository levelRepository;
	
	@Autowired
	CounterIndicatorRepository counterIndicatorRepository;


	@Transactional(readOnly = true)
	public  Iterable<Indicator>  graph_terms(int limit) {
		 Iterable<Indicator> result = indicatorRepository.findAll();
		return result;
	}
	
//	@Transactional(readOnly = true)
//	public Collection<Level>  graph_level(int limit) {
//		Collection<Level> result = termsRepository.graph_level(limit);
//		return result;
//	}
	
//	@Transactional(readOnly = true)
//	public Collection<Indicator>  graph_indicator(int limit) {
//		Collection<Indicator> result = termsRepository.graph_indicator(limit);
//		return result;
//	}
	
	@Transactional(readOnly = true)
	public Indicator  postnode(Indicator indicator) {
		Indicator result = indicatorRepository.save(indicator);
		return result;
	}
	
	@Transactional(readOnly = true)
	public Indicator  findlevelbyid(int i) {
		Indicator result = indicatorRepository.findOne((long) i);
		return result;
	}
	
	@Transactional(readOnly = true)
	public Level  findlevelbyname(String name) {
		Level result = levelRepository.findByName(name);
		System.out.println(result.getName());
		return result;
	}

	@Transactional(readOnly = true)
	public String  postnodecounter(CounterIndicator counterIndicator) {
		CounterIndicator result = counterIndicatorRepository.save(counterIndicator);
		return "node saved";
	}
	
	@Transactional(readOnly = true)
	public Collection<Terms>  listterms(int limit) {
		Collection<Terms> result = indicatorRepository.graph_terms(limit);
		return result;
	}
	
}
