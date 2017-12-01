package com.stackroute.neo4j.domain;
import java.util.Map;

public class IndexerModel {
    

    private String title;
    private String snippet;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSnipet() {
        return snippet;
    }
    public void setSnipet(String snipet) {
        this.snippet = snipet;
    }
    private String url;
    private String domain;
    private String concept;
    private Map<String, Double> csmap;
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
        return concept;
    }
    public void setConcept(String concept) {
        this.concept = concept;
    }
    public Map<String, Double> getCsmap() {
        return csmap;
    }
    public void setCsmap(Map<String, Double> csmap) {
        this.csmap = csmap;
    }
    
    public IndexerModel(String title, String snippet, String url, String domain, String concept,
            Map<String, Double> csmap) {
        super();
        this.title = title;
        this.snippet = snippet;
        this.url = url;
        this.domain = domain;
        this.concept = concept;
        this.csmap = csmap;
    }
    public IndexerModel() {
        super();
    }

    
    
}