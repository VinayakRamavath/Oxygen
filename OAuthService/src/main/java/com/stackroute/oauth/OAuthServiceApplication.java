package com.stackroute.oauth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.stackroute.oauth.configuration.CustomUserDetails;
import com.stackroute.oauth.services.OAuthCRUDRepositoryMySqlImpl;

@SpringBootApplication
public class OAuthServiceApplication {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(OAuthServiceApplication.class, args);
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder builder, OAuthCRUDRepositoryMySqlImpl repository) throws Exception {		
		builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
	}

	private UserDetailsService userDetailsService(final OAuthCRUDRepositoryMySqlImpl repository) {
		return username -> new CustomUserDetails(repository.findUser(username));
	}
}
