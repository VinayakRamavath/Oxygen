package com.stackroute.neo4j.messenger;

public class ProducerDomain {

	
	private int id;
	private String domain;
	private String concept;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getConcept() {
		return concept;
	}
	public void setConcept(String concept) {
		this.concept = concept;
	}
	public ProducerDomain(int id, String domain, String concept) {
		super();
		this.id = id;
		this.domain = domain;
		this.concept = concept;
	}
	
}
