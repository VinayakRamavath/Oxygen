package com.intentgraph.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intentgraph.domain.IntentOf;
import com.intentgraph.domain.Level;
import com.intentgraph.domain.Query;
import com.intentgraph.domain.SameAs;
import com.intentgraph.domain.Terms;
import com.intentgraph.repository.IntentRepository;
import com.intentgraph.repository.LevelRepository;
import com.intentgraph.repository.QueryRepository;
import com.intentgraph.repository.TermsRepository;

@Service
public class IntentService implements IntentInterface {

	@Autowired
	IntentRepository intentRepository;

	@Autowired
	QueryRepository queryRepository;

	@Autowired
	TermsRepository termsRepository;

	@Autowired
	LevelRepository levelRepository;

	@Transactional(readOnly = true)
	public Iterable<IntentOf> graph_node(int limit) {
		Iterable<IntentOf> result = intentRepository.findAll();
		return result;
	}

	@Transactional(readOnly = true)
	public String postnode(IntentOf intentOf) {
		IntentOf result = intentRepository.save(intentOf);
		return "node saved";
	}

	@Transactional(readOnly = true)
	public Query findquerybyname(String name) {
		Query result = queryRepository.findByName(name);
		return result;
	}

	@Transactional(readOnly = true)
	public Level findlevelbyname(String name) {
		Level result = levelRepository.findByName(name);
		return result;
	}

	@Transactional(readOnly = true)
	public Terms findtermsbyname(String name) {
		Terms result = termsRepository.findByName(name);
		return result;
	}

	@Override
	public String postnode1(SameAs sameAs) {
		// TODO Auto-generated method stub
		return null;
	}

}
