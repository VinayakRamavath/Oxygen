package com.stackroute.neo4j.domain;



import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;


@NodeEntity
public class Concept1 {



	@GraphId
	private Long id;

	@Property(name="name")
	private String name;
	
	private String context;

	private String description;

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

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getDescription() {
		return description;
	}

	public Concept1() {
		super();
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Concept1(String name, String context, String description) {
		super();
		this.name = name;
		this.context = context;
		this.description = description;
	}


	

}
