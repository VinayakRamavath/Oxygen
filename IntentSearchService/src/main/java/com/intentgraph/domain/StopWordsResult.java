package com.intentgraph.domain;

import java.util.ArrayList;

public class StopWordsResult {

	ArrayList<String> key = new ArrayList<String>();
	ArrayList<String> queryIntent = new ArrayList<String>();
	private String query;
	private String correctedquery;

	public ArrayList<String> getKey() {
		return key;
	}

	public void setKey(ArrayList<String> key) {
		this.key = key;
	}

	public ArrayList<String> getQueryIntent() {
		return queryIntent;
	}

	public void setQueryIntent(ArrayList<String> queryIntent) {
		this.queryIntent = queryIntent;
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

