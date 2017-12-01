package com.stackroute.Parser.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.Parser.Exceptions.UrlDocumentNotFound;
import com.stackroute.Parser.messenger.Listener;
import com.stackroute.Parser.messenger.Sender;
import com.stackroute.Parser.model.ParserModel;

@RequestMapping("v1/semanticsearch/parserservice")
@RestController
public class ParserController  {

	Logger  logger = Logger.getLogger(ParserController.class.getName());
	
	@Autowired
	Sender send;
//	String[] keywords = { "install","angular","angular 4","angular-cli"};
//	String url="https://coursetro.com/posts/code/55/How-to-Install-an-Angular-4-App";
	
	@Autowired
	Listener listen;

	
	@RequestMapping()
	public ResponseEntity<?> getUrlScore() throws UrlDocumentNotFound, MalformedURLException, IOException{
		ParserModel parsermodel= new ParserModel();
		parsermodel = listen.getParserm();
		
//		custom exception handling
		if(Jsoup.connect(parsermodel.getUrl()).get() == null) {
			logger.error("The Url Is Not Providing Any Information");
			throw new UrlDocumentNotFound("The Url Is Not Providing Any Information");
		}
		else {	
			send.send(parsermodel);
		return new ResponseEntity<ParserModel>(parsermodel,HttpStatus.OK);	
		}
	}
}
