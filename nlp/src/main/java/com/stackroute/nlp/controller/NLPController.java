package com.stackroute.nlp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.nlp.service.NLPPosService;
import com.stackroute.nlp.service.NameFinderTrainUtil;

@RestController
@RequestMapping("/nlp")
public class NLPController {
	
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Autowired
	NLPPosService nlpPOSservice;
	
	@Autowired
	NameFinderTrainUtil nt;
	
	@RequestMapping(value="/pos")
	public ResponseEntity<?> getStringWithPos(){
		
		// nlpPOSservice.findPos();
		
		return new ResponseEntity<String>("Success", HttpStatus.OK);
		
	}
	@RequestMapping(value="/train")
	public ResponseEntity<?> nlp(){
		
		 nt.namefindertrain();
		
		return new ResponseEntity<String>("Success", HttpStatus.OK);
		
	}
	


}
