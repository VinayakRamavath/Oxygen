package com.stackroute.neo4j.exceptions;

public class UserNotFoundException extends Exception{
	
	public UserNotFoundException(String message) {
        super(message);
    }
}
