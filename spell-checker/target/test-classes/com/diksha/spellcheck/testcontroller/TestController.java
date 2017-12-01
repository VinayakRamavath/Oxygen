//package com.diksha.spellcheck.testcontroller;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//import org.springframework.boot.context.embedded.LocalServerPort;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//
//
//
//
//import ch.qos.logback.classic.Level;
//
//
//import static org.junit.Assert.*;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.context.embedded.LocalServerPort;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.diksha.spellcheck.Application;
//import com.diksha.spellcheck.domain.SpellCheckSuggestions;
//
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class TestController {
//	    String user1;
//	    @LocalServerPort
//	    private int port;
//	    SpellCheckSuggestions spellCheckSuggestions;
//	    TestRestTemplate restTemplate = new TestRestTemplate();
//	    HttpHeaders headers = new HttpHeaders();
//	    
//	    
//	    
//	    private String createURLWithPort(String uri) {
//	        return "http://localhost:" + port + uri;
//	    }
//	    @After
//	    public void tearDown() throws Exception {
//	    }
//	    @Test
//	    public void testSaveUser() throws Exception {
////	        HttpEntity<SpellCheckSuggestions> entity = new HttpEntity<SpellCheckSuggestions>(spellCheckSuggestions, headers);
////	        ResponseEntity<String> response = restTemplate.exchange(
////	                createURLWithPort("/spellcheck/query/string"),
////	                HttpMethod.POST, entity, String.class);
////	        assertNotNull(response);
////	        String actual = response.getBody();
////	        System.out.println(actual);
//////	        assertEquals("all nodes created from csv",actual);
////	        assertNotNull(response);
//	    }
//	    
//	    
//}
