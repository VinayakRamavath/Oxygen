package com.stackroute.oauth.services;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderService {
	@Bean
	public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
