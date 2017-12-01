package com.stackroute.domainexpert.model;

import org.springframework.stereotype.Component;

@Component
public class DomainExpertModel {
	
	private String Domain;
	private String Concept;
	
	public String getDomain() {
		return Domain;
	}
	
	public void setDomain(String domain) {
		Domain = domain;
	}
	
	public String getConcept() {
		return Concept;
	}
	
	public void setConcept(String concept) {
		Concept = concept;
	}

}
