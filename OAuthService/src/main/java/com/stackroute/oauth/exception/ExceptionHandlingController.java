package com.stackroute.oauth.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CustomExceptionResponse> invalidInput(MethodArgumentNotValidException exception) {
		
		BindingResult result = exception.getBindingResult();
        CustomExceptionResponse exceptionresponse = new CustomExceptionResponse();
        
        exceptionresponse.setErrorMessage("Invalid Inputs.");
        exceptionresponse.setErrorDescription(result.getFieldErrors().get(0).getDefaultMessage());
        
        return new ResponseEntity<CustomExceptionResponse>(exceptionresponse, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(UserExistsException.class)
	public ResponseEntity<CustomExceptionResponse> userexits(UserExistsException exception) {
        CustomExceptionResponse exceptionresponse = new CustomExceptionResponse();
        
        exceptionresponse.setErrorMessage("User already registered");
        exceptionresponse.setErrorDescription(exception.getMessage());
        
        return new ResponseEntity<CustomExceptionResponse>(exceptionresponse, HttpStatus.OK);
	}
	
	
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<CustomExceptionResponse> userexits(InvalidPasswordException exception) {
        CustomExceptionResponse exceptionresponse = new CustomExceptionResponse();
        
        exceptionresponse.setErrorMessage("Invalid password.");
        exceptionresponse.setErrorDescription(exception.getMessage());
        
        return new ResponseEntity<CustomExceptionResponse>(exceptionresponse, HttpStatus.BAD_REQUEST);
	}
}
