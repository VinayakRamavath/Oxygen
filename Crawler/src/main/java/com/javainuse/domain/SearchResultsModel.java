package com.javainuse.domain;

import java.util.List;

public class SearchResultsModel {
	
	private String domain;
	private String concept;
	private List<Result> items;

	/**
	 * @return the items
	 */
	public List<Result> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<Result> items) {
		this.items = items;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	
	
}
