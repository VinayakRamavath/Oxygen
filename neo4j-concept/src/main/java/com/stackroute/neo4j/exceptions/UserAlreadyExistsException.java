package com.stackroute.neo4j.exceptions;

 
public class UserAlreadyExistsException extends Exception{
	
	public UserAlreadyExistsException(String message) {
        super(message);
    }
}
