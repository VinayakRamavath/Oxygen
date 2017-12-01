package com.stackroute.github.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.stackroute.github.domain.DomainConcept;
import com.stackroute.github.domain.SearchResultsModel;

//Interface for all the services

public interface ApiService{
	
	public SearchResultsModel callAPI(String apikey,int startIndex) throws Exception;
	public Iterable<DomainConcept> fetchresults() throws Exception;
	public void setDomconc(String domain,String concept);
//	public void saveDC(DomainConcept domainconcept);
}
