package com.stackroute.oauth.exception;

public class CustomExceptionResponse {
    private String errorMessage;
    private String errorDescription;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorDescription() {
		return errorDescription	;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
}
