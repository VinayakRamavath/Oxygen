package com.stackroute.index.model;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class IndexerModel {
	

	private String url;
    private String domain;
    private String concept;
    private String title;
    private String snippet;
    private Map<String,Double> csmap;
    
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSnipet() {
		return snippet;
	}
	public void setSnipet(String snipet) {
		this.snippet = snipet;
	}
	public void setConcept(String concept) {
		this.concept = concept;
	}


	public IndexerModel() {
		super();
	}
	public Map<String,Double> getCsmap() {
		return csmap;
	}
	public void setCsmap(Map<String,Double> csmap) {
		this.csmap = csmap;
	}

	
	
}
