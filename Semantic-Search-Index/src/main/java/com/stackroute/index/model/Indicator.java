package com.stackroute.index.model;

public class Indicator {

	private Long id;

	private float weight;

	private Terms terms;

	private Object level;


	public Indicator() {
		super();
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

	public Object getLevel() {
		return level;
	}

	public void setLevel(Object level) {
		this.level = level;
	}

	public Indicator(Terms terms, Level level) {
		super();
		this.terms = terms;
		this.level = level;
	}

	public Indicator(Long id, float weight, Terms terms, Object level) {
		super();
		this.id = id;
		this.weight = weight;
		this.terms = terms;
		this.level = level;
	}

}