package com.stackroute.neo4j.domain;

import java.util.ArrayList;
import java.util.Collection;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@RelationshipEntity(type = "subconcept_of")
public class Subconcept {

	@GraphId
	private Long id;

	private String name;


	@StartNode
	private Concept1 concept1;

	@EndNode
	private Concept2 concept2;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Concept1 getConcept1() {
		return concept1;
	}

	public void setConcept1(Concept1 concept1) {
		this.concept1 = concept1;
	}

	public Concept2 getConcept2() {
		return concept2;
	}

	public void setConcept2(Concept2 concept2) {
		this.concept2 = concept2;
	}

	public Subconcept(String name, Concept1 concept1, Concept2 concept2) {
		super();
		this.name = name;
		this.concept1 = concept1;
		this.concept2 = concept2;
	}

	public Subconcept() {
		super();
	}

	
}

