package com.stackroute.oauth.exception;

public class InvalidPasswordException extends Exception {
	static final long serialVersionUID = 42L;
	
	private String errormessage;
	
	public InvalidPasswordException (String errormessage) {
		super(errormessage);
		this.errormessage = errormessage;
	}

	public String getErrormessage() {
		return errormessage;
	}
}
