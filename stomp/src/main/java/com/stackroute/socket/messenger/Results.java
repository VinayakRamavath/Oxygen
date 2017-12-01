package com.stackroute.socket.messenger;

public class Results {

	private String query;
	private ListUrls listUrls;
	public ListUrls getListUrls() {
		return listUrls;
	}
	public void setListUrls(ListUrls listUrls) {
		this.listUrls = listUrls;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public Results(String query, ListUrls listUrls) {
		super();
		this.query = query;
		this.listUrls = listUrls;
	}
	public Results() {
		super();
	}
	
}
