package com.intentgraph.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
public class Query {
	@GraphId
	private Long id;

	@Property(name="name")
	private String name;

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

	public Query(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Query(String name) {
		super();
		this.name = name;
	}

	public Query() {
		super();
	}
	

}
