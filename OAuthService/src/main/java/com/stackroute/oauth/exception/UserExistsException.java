package com.stackroute.oauth.exception;

public class UserExistsException extends Exception {
	static final long serialVersionUID = 42L;
	
	private String errormessage;
	
	public UserExistsException (String errormessage) {
		super(errormessage);
		this.errormessage = errormessage;
	}

	public String getErrormessage() {
		return errormessage;
	}
}
