package com.stackroute.neo4j.messenger;

import java.util.Map;

public class IndexerModel {

    private String url;
    private Map<String, Double> CSMap;
    
    public String getUrl() {
        return url;
    }
    public IndexerModel(String url, Map<String, Double> cSMap) {
        super();
        this.url = url;
        CSMap = cSMap;
    }
    public IndexerModel() {
		super();
	}
	public void setUrl(String url) {
        this.url = url;
    }
    public Map<String, Double> getCSMap() {
        return CSMap;
    }
    public void setCSMap(Map<String, Double> cSMap) {
        CSMap = cSMap;
    }
    
}