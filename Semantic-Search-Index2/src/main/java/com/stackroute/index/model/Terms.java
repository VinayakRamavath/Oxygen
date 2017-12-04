package com.stackroute.index.model;

public class Terms {

	private Long id;

	private String name;

	public Terms() {
		super();
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

	public Terms(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
