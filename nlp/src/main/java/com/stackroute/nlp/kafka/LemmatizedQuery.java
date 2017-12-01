package com.stackroute.nlp.kafka;

import java.util.HashMap;
import java.util.Map;

/*
 * Model Class for lemmatizer. It contains the lemmatized query and
 * the parts of speech of the respective words
 */
public class LemmatizedQuery {

	
	private String[] lemQuery;
	
	private String query;
	private String correctedquery;

	
	public String[] getLemQuery() {
		return lemQuery;
	}
	public void setLemQuery(String[] lemQuery) {
		this.lemQuery = lemQuery;
	}
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



	
	
}