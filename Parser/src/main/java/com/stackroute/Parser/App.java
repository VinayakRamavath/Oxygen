package com.stackroute.Parser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


// Parser Spring Boot Rest Api Application
//@EnableDiscoveryClient
@SpringBootApplication
@EnableAutoConfiguration
public class App{
	public static void main(String args[]) {
	
	SpringApplication.run(App.class, args);
	}
}
