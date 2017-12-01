package com.javainuse.domain;

public class CrawlerModel {

	String url;
	String domain;
	String Concept;
	String doc;
	String title;
	String snippet;
	
	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getConcept() {
		return Concept;
	}

	public void setConcept(String concept) {
		Concept = concept;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String googleresult) {
		this.url = googleresult;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}
	
	public String toString() {
		return ("title"+getTitle()+"\n"+
				"Url"+getUrl()+"\n"+
				"Snippet"+getSnippet()+"\n"
				);
		
	}

}
