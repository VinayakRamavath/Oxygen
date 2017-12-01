package com.stackroute.neo4j.domain;


import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;


@NodeEntity
public class Terms {



	@GraphId
	private Long id;

	private String name;

	public Terms() {
	}

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

	public Terms(String name) {

		this.name = name;
	}
	
}
