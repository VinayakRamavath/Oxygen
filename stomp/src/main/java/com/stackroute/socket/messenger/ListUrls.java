package com.stackroute.socket.messenger;

import java.util.List;


public class ListUrls {
	
	private String query;
	private String correctedquery;
	private String concept;
	private String intent;
	private List<UrlRelation> result;
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getCorrectedquery() {
		return correctedquery;
	}
	public void setCorrectedquery(String correctedquery) {
		this.correctedquery = correctedquery;
	}
	public String getConcept() {
		return concept;
	}
	public void setConcept(String concept) {
		this.concept = concept;
	}
	public String getIntent() {
		return intent;
	}
	public void setIntent(String intent) {
		this.intent = intent;
	}
	public List<UrlRelation> getResult() {
		return result;
	}
	public void setResult(List<UrlRelation> result) {
		this.result = result;
	}
	public ListUrls(String query, String correctedquery, String concept, String intent, List<UrlRelation> result) {
		super();
		this.query = query;
		this.correctedquery = correctedquery;
		this.concept = concept;
		this.intent = intent;
		this.result = result;
	}
	public ListUrls() {
		super();
	}

}
