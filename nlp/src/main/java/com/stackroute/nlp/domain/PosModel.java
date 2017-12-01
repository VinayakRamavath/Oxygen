package com.stackroute.nlp.domain;

public class PosModel {

	// Query stored in array of string words
	private String[] words;

	// POS stored in array of string pos
	private String[] pos;

	private String query;

	private String correctedquery;

	public String[] getWords() {
		return words;
	}

	public void setWords(String[] words) {
		this.words = words;
	}

	public String[] getPos() {
		return pos;
	}

	public void setPos(String[] pos) {
		this.pos = pos;
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
