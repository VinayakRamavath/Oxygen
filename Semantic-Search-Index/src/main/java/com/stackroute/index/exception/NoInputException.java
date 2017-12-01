package com.stackroute.index.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoInputException extends Exception{
	
	private static final long serialVersionUID = 1L;

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public NoInputException(String message) {
		
		super(message);
		
		log.info("no input exception is found with message "+message);
	}

}
