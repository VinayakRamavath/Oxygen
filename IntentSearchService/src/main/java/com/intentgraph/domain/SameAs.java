package com.intentgraph.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "same_as")

public class SameAs {
	@GraphId
	private Long id;

	
	private String name;

	@StartNode
	private Terms terms;

	@EndNode
	private Level level;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SameAs(Terms terms, Level level) {
		super();
		this.terms = terms;
		this.level = level;
	}

	public SameAs() {
		super();
	}
	

}
