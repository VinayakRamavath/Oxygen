package com.stackroute.index.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NANException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public NANException(String msg) {
		super(msg);
		
		log.info("Term scores do not have a numerical value");
	}
	
	

}
