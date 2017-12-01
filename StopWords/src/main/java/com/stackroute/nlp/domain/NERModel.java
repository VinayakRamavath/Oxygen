package com.stackroute.nlp.domain;

import java.util.ArrayList;

public class NERModel {

	// Query stored in array of strings words
	private ArrayList<String> words;
	
	// Keywords stored in array of strings keywords
		private ArrayList<String> keywords;
		
		private String query;
		private String correctedquery;


	public NERModel() {
		super();
	}

	public NERModel(ArrayList<String> words, ArrayList<String> keywords) {
		super();
		this.words = words;
		this.keywords = keywords;
	}

	public ArrayList<String> getWords() {
		return words;
	}

	public void setWords(ArrayList<String> words) {
		this.words = words;
	}

	public ArrayList<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(ArrayList<String> keywords) {
		this.keywords = keywords;
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

