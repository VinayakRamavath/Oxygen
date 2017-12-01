package com.intentgraph.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.intentgraph.service.IntentInterface;
import com.intentgraph.service.IntentService;
import com.intentgraph.service.MainInterface;
import com.intentgraph.service.MainService;
import com.intentgraph.service.SameAsInterface;
import com.intentgraph.service.SameAsService;

import com.intentgraph.domain.SameAs;
import com.intentgraph.domain.Terms;
import com.intentgraph.domain.IntentOf;
import com.intentgraph.domain.Level;
import com.intentgraph.domain.Query;

@RestController
public class IntentController {

//	String[] query = {"explain","ways","define","how"};
//
	@Autowired
	SameAsInterface sameAsService;
////
	@Autowired
	IntentInterface intentService;
	
	@Autowired
	MainInterface mainInterface;

	
// @GetMapping("/graphconcept")
//	public @ResponseBody ResponseEntity<String> graph_concept1(String[] query) {
//	 
//	// String[] queryy= {"examples", "interface"};
//	 mainInterface.graph_concept(queryy);
//		return new ResponseEntity<String>("found", HttpStatus.OK);
//		
//	}

 @GetMapping("/graphparent")
	public @ResponseBody ResponseEntity<String> graph_parent(String query) {
	 
	 String query1= "meaning";
	 String query2=sameAsService.findquerybyname(query1);
	 System.out.println("PARENT INTENT");
	 System.out.println(query2);
		return new ResponseEntity<String>("found", HttpStatus.OK);
		
	}
	
	@CrossOrigin("*")
	 @PostMapping("/postcsvsubconcept")
	    public @ResponseBody ResponseEntity<String> savefromcsv(@RequestParam String csvname) {
	    	
		 mainInterface.saveNewSubconcept();
//		 mainInterface.saveNewSubconcept1();
	    	
	        return new ResponseEntity<String>("all nodes created from csv", HttpStatus.OK);
	    }

}
