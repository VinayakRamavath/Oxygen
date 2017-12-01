package com.stackroute.Parser.model;

public class CrawlerModel {

   private String url;
   private String domain;
   private String Concept;
   private String doc;
   private String title;
   private String snippet;
   
   
   
   public String getUrl() {
	   return url;
   }

   public void setUrl(String url) {
	   this.url = url;
   }

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

   public String getDoc() {
	   return doc;
   }

   public void setDoc(String doc) {
	   this.doc = doc;
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
