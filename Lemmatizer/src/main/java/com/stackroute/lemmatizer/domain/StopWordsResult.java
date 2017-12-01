package com.stackroute.lemmatizer.domain;


import java.util.ArrayList;

public class StopWordsResult {

//	private String[] words;
//
//	private String[] pos;

	ArrayList<String> words=new ArrayList<String>();

	ArrayList<String> pos=new ArrayList<String>();
	
	private String query;
	private String correctedquery;

	public ArrayList<String> getWords() {
		return words;
	}

	public void setWords(ArrayList<String> words) {
		this.words = words;
	}

	public ArrayList<String> getPos() {
		return pos;
	}

	public void setPos(ArrayList<String> pos) {
		this.pos = pos;
	}

	public StopWordsResult(ArrayList<String> words, ArrayList<String> pos) {
		super();
		this.words = words;
		this.pos = pos;
	}

	public StopWordsResult() {
		super();
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
