package com.stackroute.neo4j.domain;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@RelationshipEntity(type = "indicator_of")
public class Indicator {

	@GraphId
	private Long id;

	private float weight;

	@StartNode
	private Terms terms;

	@EndNode
	private Level level;

	public Indicator() {
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	public float getWeight() {
		return weight;
	}



	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Terms getTerms() {
		return terms;
	}



	public void setTerms(Terms terms) {
		this.terms = terms;
	}



	public Level getLevel() {
		return level;
	}



	public void setLevel(Level level) {
		this.level = level;
	}



	public Indicator(Terms terms, Level level) {
		super();
		this.terms = terms;
		this.level = level;
	}



	public Indicator(float weight, Terms terms, Level level) {
		super();
		this.weight = weight;
		this.terms = terms;
		this.level = level;
	}



	
}

