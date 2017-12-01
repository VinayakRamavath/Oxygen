package com.intentgraph.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intentgraph.domain.IntentOf;
import com.intentgraph.domain.Level;
import com.intentgraph.domain.Query;
import com.intentgraph.domain.SameAs;
import com.intentgraph.domain.Terms;
import com.intentgraph.repository.LevelRepository;
import com.intentgraph.repository.SameAsRepository;
import com.intentgraph.repository.TermsRepository;


@Service
public class SameAsService implements SameAsInterface {
	@Autowired
	LevelRepository levelRepository;
	
	@Autowired
	TermsRepository termsRepository;
	
	@Autowired
	SameAsRepository sameAsRepository;
	
	@Transactional(readOnly = true)
	public Iterable<SameAs> graph_nodes(int limit){
		Iterable<SameAs> results=sameAsRepository.findAll();
		return results;
		
	}
//	@Transactional(readOnly = true)
//	public Level  findlevelbyid(int i) {
//		Level result = levelRepository.findOne((long) i);
//		return result;
//	}
	@Transactional(readOnly = true)
	public Level  findlevelbyname(String name) {
//		Level result=null;
//		System.out.println("checking for level");
		Level result = levelRepository.findByName(name);
		return result;
	}
	@Transactional(readOnly = true)
	public String  postnode1(SameAs sameAs) {
		SameAs result = sameAsRepository.save(sameAs);
		return "node saved";
	}
	@Transactional(readOnly = true)
	public Terms  findtermsbyname(String name) {
		Terms result=null;
		System.out.println("checking for terms");
		result = termsRepository.findByName(name);
		System.out.println(result.getName());
		return result;
	}

	@Override
	public Iterable<IntentOf> graph_node(int limit) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String postnode(IntentOf intentOf) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String findquerybyname(String name) {
		System.out.println("INSIDE FINDQUERYBYNAME");
		SameAs sameAs=sameAsRepository.findByName(name);
		System.out.println(sameAs.getLevel().getName());
		return sameAs.getLevel().getName();
	}

}
