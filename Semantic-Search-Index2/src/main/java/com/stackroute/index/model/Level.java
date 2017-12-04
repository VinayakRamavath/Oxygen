package com.stackroute.index.model;

public class Level {

	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Level(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Level() {
		super();
	}

	public Level(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}