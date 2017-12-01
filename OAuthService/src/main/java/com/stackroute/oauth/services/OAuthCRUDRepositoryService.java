package com.stackroute.oauth.services;
import com.stackroute.oauth.exception.InvalidPasswordException;
import com.stackroute.oauth.exception.UserExistsException;
import com.stackroute.oauth.model.UserInfo;

public interface OAuthCRUDRepositoryService {
	public UserInfo findUser(String username);
	void save(UserInfo user) throws UserExistsException;
	void delete(UserInfo user) throws InvalidPasswordException;
	
}
