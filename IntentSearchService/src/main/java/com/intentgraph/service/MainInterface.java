package com.intentgraph.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.intentgraph.domain.IntentOf;
import com.intentgraph.domain.Level;
import com.intentgraph.domain.Query;
import com.intentgraph.domain.SameAs;

@Service
public interface MainInterface {
	public Level graph_level( String name);
	public Level graph_level1( String name);
	public  ResponseEntity<String> saveNewIndicator( SameAs sameAs);
	public  ResponseEntity<String> saveNewIntent( IntentOf intentOf);
	public Query graph_heading( String name);
	public void graph_concept(String[] query);
	public void graph_parent(String query);
	public void saveNewSubconcept();
	public void saveNewSubconcept1();

}
