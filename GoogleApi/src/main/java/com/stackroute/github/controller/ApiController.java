package com.stackroute.github.controller;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.stackroute.github.domain.DomainConcept;
import com.stackroute.github.domain.SearchResultsModel;
import com.stackroute.github.messenger.Sender;
import com.stackroute.github.services.ApiService;


@RestController
@RequestMapping(value="/semantic")
public class ApiController {

	@Autowired
	Sender kafkaSender;
    
    @Autowired 
    ApiService service;
    
  //<--- Getting Google Api Results ---> 
//    @RequestMapping(value = "/sendurls/{domain}/{concept}", method = RequestMethod.GET)
//    public ResponseEntity <String> showSearchresults(@PathVariable() String domain,@PathVariable() String concept) throws Exception {	
////    	String array[]=new String[10];
////    	
////    	service.setDomconc(domain,concept);
////    	try {
////    		
////    		 JSONParser parser = new JSONParser();
////    	        Object object = parser.parse(new FileReader("/home/harsh/Dry Run/semanticsearch-master-d8cd5d12209c82456dae8768a9d869026482b5e0/GoogleApi/complete/src/main/java/com/stackroute/github/services/apikeys.json"));
////    	        
////    	        JSONObject jsonobject = (JSONObject)object;
////    	        List<String> list = new ArrayList<>();
////    	        JSONArray apikeys = (JSONArray)jsonobject.get("apikeys");
////    	        
////    	        for(Object apik : apikeys) {
//////    	        	System.out.println(apik.toString());
////    	        	list.add(apik.toString());
////    	        }
////    	        
////    	        int startIndex = 1;
////    	        for(int j =0;j<2;j++) {
////    	        	String apikey = list.get(j);
////    	        	System.out.println(apikey);
////    	        	SearchResultsModel a  = service.callAPI(apikey, startIndex);
////    	            
////    	        	kafkaSender.send(a);
////    	        	
////    	        	System.out.println(a.getItems().get(0).getFormattedUrl());
////    	            startIndex = startIndex +10;
////    	           
////    	            
//////    	            userRepository.save(results);
////    	        }
////
////    		return new ResponseEntity<String>("Success", HttpStatus.CREATED );
////		} catch (Exception e) {
////			
////			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
////		}
//           
//    }
    
    @RequestMapping(value = "/fetchresults", method = RequestMethod.GET)
    public Iterable<DomainConcept> resultscontnet() throws Exception {	
    	Iterable<DomainConcept> results=service.fetchresults();

		return results;
           
    }
    
   
}
