package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.example.demo.filters.ErrorFilter;
import com.example.demo.filters.PostFilter;
import com.example.demo.filters.PreFilter;
import com.example.demo.filters.RouteFilter;



@SpringBootApplication

/*this annotation uses netflix zuul as a gateway to microservice*/
@EnableDiscoveryClient

/*this annotation registers this service on eureka discovery service*/
@EnableZuulProxy


//main class for api-gateway
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	//accepts the request from the client
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	
	//gives back the response to the client that is been sent by the microservice
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	//routes to given path of the micro service
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}
