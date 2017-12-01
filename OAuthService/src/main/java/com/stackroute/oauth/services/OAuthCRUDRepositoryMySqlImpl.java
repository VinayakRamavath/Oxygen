package com.stackroute.oauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stackroute.oauth.exception.InvalidPasswordException;
import com.stackroute.oauth.exception.UserExistsException;
import com.stackroute.oauth.model.UserInfo;
import com.stackroute.oauth.repository.OAuthCRUDRepository;

@Service
public class OAuthCRUDRepositoryMySqlImpl implements OAuthCRUDRepositoryService {
	@Autowired
	PasswordEncoderService ps;
	
	@Autowired
	private OAuthCRUDRepository repoobject;
	
	/*	
	save a user
	*/
	@Override
	public void save(UserInfo user) throws UserExistsException {
		if(repoobject.findByEmail(user.getEmail()) == null) {
			
				user.setPassword(ps.getPasswordEncoder().encode(user.getPassword()));
				repoobject.save(user);
				
			
		} else {
			throw new UserExistsException("The email " + user.getEmail() + " is already registered");
		}
	}

	/*
	find user by email
	*/
	@Override
	public UserInfo findUser(String email) {
		return repoobject.findByEmail(email);
	}

	/*
	delete user 
	*/

	@Override
	public void delete(UserInfo user) throws InvalidPasswordException {
		if(ps.getPasswordEncoder().matches(user.getPassword(), repoobject.findByEmail(user.getEmail()).getPassword())) {
			repoobject.delete(repoobject.findByEmail(user.getEmail()));
			
			
		} else {
			throw new InvalidPasswordException("Incorrect password");
		}
	}


}
