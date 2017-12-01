package com.stackroute.oauth.repository;
import org.springframework.data.repository.CrudRepository;
import com.stackroute.oauth.model.UserInfo;

public interface OAuthCRUDRepository extends CrudRepository<UserInfo, Long>{
	public UserInfo findByEmail(String email);
//	public UserInfo findByPsaid(Integer psaid);
}
