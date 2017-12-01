//package com.stackroute.parser.controller;
//
//import org.junit.After;
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
//import com.stackroute.Parser.App;
//
//
//import junit.framework.TestCase;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class ParserControllerTest extends TestCase {
//	
//	@LocalServerPort
//	private int port;
//	
//	TestRestTemplate restTemplate = new TestRestTemplate();
//	
//	HttpHeaders headers = new HttpHeaders();
//
//	private String createURLWithPort(String uri) {
//        return "http://localhost:" + port + uri;
//    }
//	
//	@After
//    public void tearDown() throws Exception {
//    }
//	
//	
//	
//    @Test
//    public void testGetUrlScore() throws Exception {
////        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
////        ResponseEntity<String> response = restTemplate.exchange(
////                createURLWithPort(""),
////                HttpMethod.GET, entity, String.class);
////        assertNotNull(response);
//    }
//    
//
//}
