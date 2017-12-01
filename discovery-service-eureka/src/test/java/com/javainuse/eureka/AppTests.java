//package com.javainuse.eureka;
//
//
//import static org.junit.Assert.*;
//
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.embedded.LocalServerPort;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import org.springframework.test.context.junit4.SpringRunner;
//
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class AppTests {
//	
//	 @LocalServerPort
//	    private int port;
//
//	    @Autowired
//	    private TestRestTemplate testRestTemplate;
//
//	    @Test
//	    public void shouldStartEurekaServer() {
//	        ResponseEntity<String> entity = this.testRestTemplate.getForEntity(
//	                "http://localhost:" + this.port + "/eureka/apps", String.class);
//
//	        assertEquals(HttpStatus.OK,entity.getStatusCode());
//}
//	    
//	    
//	    @Test
//	    public void shouldStopEurekaServer() {
//	        ResponseEntity<String> entity = this.testRestTemplate.getForEntity(
//	                "http://localhost:" + this.port + "/eureka/missing", String.class);
//
//	        assertEquals(HttpStatus.NOT_FOUND,entity.getStatusCode());
//	    }
//}
