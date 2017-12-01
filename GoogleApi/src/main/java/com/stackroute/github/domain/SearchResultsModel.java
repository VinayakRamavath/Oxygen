package com.stackroute.github.domain;


import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="apidatabase")
public class SearchResultsModel {
	 
	
	public SearchResultsModel(){}
	 
	private String domain;
	private String concept;
	public SearchResultsModel(String domain, String concept, List<Result> items) {
		super();
		this.domain = domain;
		this.concept = concept;
		this.items = items;
	}

	private List<Result> items;
	 
	
	public List<Result> getItems() {
		return items;
	}
	public void setItems(List<Result> items) {
		this.items = items;
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

  
	
	
	
	
    

  
}


