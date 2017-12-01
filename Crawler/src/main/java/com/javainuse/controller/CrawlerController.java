package com.javainuse.controller;

import java.io.IOException;

/*
 * Controller for crawler service
 */

import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.domain.CrawlerModel;
import com.javainuse.domain.CustomUrl;
import com.javainuse.exception.UrlNotFound;
import com.javainuse.kafka.Sender;
import com.javainuse.service.CrawlerServices;

@RequestMapping("/v1/semanticsearch/crawlerservice")
@RestController
public class CrawlerController {
	Logger logger = Logger.getLogger(CrawlerController.class.getName());

	// to create KafkaSender object
	@Autowired
	Sender kafkaSender;

	// to create CrawlerServices object
	CrawlerServices crawlerservices = new CrawlerServices();
	
		
	@CrossOrigin("*")
	@RequestMapping()
	public ResponseEntity<?> getCrawlerResult()
			throws MalformedURLException, IOException, UrlNotFound, InterruptedException, ExecutionException {


		return new ResponseEntity<String>("crawler response", HttpStatus.OK);
}
	
	 @CrossOrigin("*")
	    @PostMapping("/posturl")
	    public ResponseEntity<?> add(@RequestBody CustomUrl customurl) throws InterruptedException, IOException {
		 CrawlerModel crawlerModel = new CrawlerModel();
		 Document pageContent = crawlerservices.PageContent(customurl.getUrl());
		 
		 String title= customurl.getDomain()+" "+customurl.getConcept()+" "+"(Recomended By Domain Expert)";
		 String snippet="This Url is custom added by the domain expert" + " "+"Domain:"+customurl.getDomain()+" "+ "Concept:"+customurl.getConcept() ;
		 
		 	crawlerModel.setUrl(customurl.getUrl());
			crawlerModel.setDomain(customurl.getDomain());
			crawlerModel.setConcept(customurl.getConcept());
			crawlerModel.setDoc(pageContent.toString());
			crawlerModel.setSnippet(snippet);
			crawlerModel.setTitle(title);
			
			kafkaSender.send(crawlerModel);
			
		 
			return new ResponseEntity<String>("Url Succesfully Added.", HttpStatus.OK);
	        
	 }
	
}		
			
			
	
