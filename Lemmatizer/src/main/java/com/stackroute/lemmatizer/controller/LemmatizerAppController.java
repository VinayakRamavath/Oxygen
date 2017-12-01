package com.stackroute.lemmatizer.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.lemmatizer.domain.LemmatizedQuery;
import com.stackroute.lemmatizer.messenger.Listener;
import com.stackroute.lemmatizer.messenger.Sender;
import com.stackroute.lemmatizer.service.LemmatizerAppService;

@RestController
@RequestMapping()
public class LemmatizerAppController {


	public ResponseEntity<?> lemmatize() throws IOException{

		
		return new ResponseEntity("Lemmatizer Working",HttpStatus.OK);
	}
}