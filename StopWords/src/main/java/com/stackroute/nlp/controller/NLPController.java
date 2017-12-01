package com.stackroute.nlp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stackroute.nlp.service.StopWordsService;


/*
 * Stopwords Controller
 */
@Controller
public class NLPController {

	@Autowired
	StopWordsService nlpservice;
	
	@RequestMapping()
	public ResponseEntity<?> getStringWithoutStopwords(){

		return new ResponseEntity<String>("done", HttpStatus.OK);
		
	}

}
