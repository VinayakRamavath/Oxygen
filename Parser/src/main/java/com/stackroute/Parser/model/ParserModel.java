package com.stackroute.Parser.model;

import java.util.Map;

import org.springframework.stereotype.Component;


@Component
public class ParserModel {
	
	private String url;
	private String domain;
	private String concept;
	private String title;
    private String snippet;
	private Map<String,Integer> terms;
		
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Map<String,Integer> getTerms() {
		return terms;
	}
	public void setTerms(Map<String,Integer> terms) {
		this.terms = terms;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSnippet() {
		return snippet;
	}
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}
	
	
	
}
