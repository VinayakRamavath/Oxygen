package com.stackroute.github.domain;


public class Result {
	 
	 private String title;
     private String displayLink;
     private String snippet;
     private String link;
//     private String htmlTitle;
//     private String htmlsnippet;
//     private String cacheId;
//     private String htmlFormattedUrl;

public Result(String title) {
	super();
	this.title = title;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDisplayLink() {
	return displayLink;
}
public void setDisplayLink(String displayLink) {
	this.displayLink = displayLink;
}
public String getSnippet() {
	return snippet;
}
public void setSnippet(String snippet) {
	this.snippet = snippet;
}
public String getLink() {
	return link;
}
public void setLink(String link) {
	this.link = link;
}
public Result(String title, String displayLink, String snippet, String link) {
	super();
	this.title = title;
	this.displayLink = displayLink;
	this.snippet = snippet;
	this.link = link;
}
	
     
		
		
}
