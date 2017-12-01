package com.stackroute.github.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="domainconceptdatabase")
public class DomainConcept {
	private String domain;
	private String concept;
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	

	
//	public DomainConcept(int id, String domain, String concept) {
//		super();
//		this.id = id;
//		this.domain = domain;
//		this.concept = concept;
//	}
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
	
	
	public DomainConcept() {
		
	}

}
