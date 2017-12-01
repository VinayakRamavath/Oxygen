package com.stackroute.oauth.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.oauth.exception.InvalidPasswordException;
import com.stackroute.oauth.exception.UserExistsException;
import com.stackroute.oauth.model.UserInfo;
import com.stackroute.oauth.repository.OAuthCRUDRepository;
import com.stackroute.oauth.services.OAuthCRUDRepositoryMySqlImpl;

import io.swagger.annotations.Api;


@RestController
@Api(value="OAuth Service", description="Provides security to the product")
@CrossOrigin("*")
public class OAuthServiceController {
	
	@Autowired
	OAuthCRUDRepositoryMySqlImpl mysqlservice;
	
	@Autowired
	ConsumerTokenServices tokenservice;
	
	@Autowired
	OAuthCRUDRepository repo;

	
	/*
	register a user with the app
	*/
	@PostMapping(value="/register", consumes="application/json")
	public ResponseEntity<String> setUserInfo(@Valid @RequestBody UserInfo user){
		try {
		mysqlservice.save(user);
		return new ResponseEntity<String> ("New user created.", HttpStatus.OK);
		}
		catch(UserExistsException e) {
			return new ResponseEntity<String> ("User Already Exists",HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/users/{email:.+}")
	public ResponseEntity<?>getUserDetails(@PathVariable("email") String email){
		
		try {
			
			UserInfo user=repo.findByEmail(email);
			
			return new ResponseEntity<UserInfo>(user,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("user not found",HttpStatus.NO_CONTENT);
		}
		
	}
	
	/*
	used during logout internally
	*/
	@GetMapping(value="/revoketoken")
	public ResponseEntity<String> deleteToken(@RequestHeader(value="Authorization") String accesstoken) {

		String[] splittedtoken = accesstoken.split(" ");
		tokenservice.revokeToken(splittedtoken[1]);
		accesstoken=null;
		return new ResponseEntity<String> ("Access token revoked", HttpStatus.OK);
	}
	
	/*
	to deactivate a users account
	*/
	@DeleteMapping(value="/deactivateaccount")
	public ResponseEntity<String> deleteUser(@RequestBody UserInfo user) throws InvalidPasswordException {
		mysqlservice.delete(user);
		return new ResponseEntity<String>("Account Deleted.", HttpStatus.OK);
	}
	

	
}
