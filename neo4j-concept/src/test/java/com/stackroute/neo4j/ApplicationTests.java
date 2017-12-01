//package com.stackroute.neo4j;
//
//import junit.framework.TestCase;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.runner.RunWith;
//import org.junit.Test;
//import org.springframework.boot.context.embedded.LocalServerPort;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.*;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.stackroute.neo4j.Application;
//import com.stackroute.neo4j.domain.Concept1;
//import com.stackroute.neo4j.domain.Concept2;
//import com.stackroute.neo4j.domain.Subconcept;
//import com.stackroute.neo4j.domain.UrlFromGoogle;
//import com.stackroute.neo4j.domain.UrlRelation; 
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class ApplicationTests  extends TestCase {
//   
//	@LocalServerPort
//	private int port;
//	TestRestTemplate restTemplate = new TestRestTemplate();
//	HttpHeaders headers = new HttpHeaders();
//	Subconcept user;
//	Concept1 concept1;
//	Concept2 concept2;
//	
//	UrlRelation urlRelation;
//	UrlFromGoogle urlFromGoogle;
//    
//	@Before
//    public void setUp() throws Exception {
//		concept1=new Concept1("concept1","context","description");
//		concept2=new Concept2("concept2","context","description");
//		user = new Subconcept("vinay",concept1,concept2);
//		urlFromGoogle=new UrlFromGoogle("urlFromGoogle","title","snippet");
//		float i=1;
//		urlRelation=new UrlRelation( i,i,i,i,i,i,urlFromGoogle,concept2);
//    }
//	
//    private String createURLWithPort(String uri) {
//        return "http://localhost:" + port + "/v1.0/semantic/neo4jconceptservice" + uri;
//    }
//    
//    @After
//    public void tearDown() throws Exception {
//    }
//    
//    @Test
//    public void testSaveUserWithoutName() throws Exception { 
//    	String actual = ""; 
//    	HttpHeaders headers = new HttpHeaders();
//	    headers.setContentType(MediaType.APPLICATION_JSON);
//	    HttpEntity<Subconcept> entity = new HttpEntity<Subconcept>(user, headers); 
//	    ResponseEntity<String> response = restTemplate.exchange(
//	             createURLWithPort("/postsubconcept"),
//	             HttpMethod.POST, entity, String.class); 
//	    assertNotNull(response);
//        
//    }
//    
//    @Test
//    public void testList() throws Exception {
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort("/graphconcept/vinay"),
//                HttpMethod.GET, entity, String.class);
//        assertNotNull(response);
//    } 
//    
//    @Test
//    public void testSaveWithoutName() throws Exception { 
//    	String actual = ""; 
//    	HttpHeaders headers = new HttpHeaders();
//	    headers.setContentType(MediaType.APPLICATION_JSON);
//	    HttpEntity<Subconcept> entity = new HttpEntity<Subconcept>(user, headers); 
//	    ResponseEntity<String> response = restTemplate.exchange(
//	             createURLWithPort("/postsubconcept"),
//	             HttpMethod.POST, entity, String.class); 
//	    assertNotNull(response);
//        
//    }
//    
//    @Test
//    public void testurl() throws Exception {
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort("/graphurl/vinay"),
//                HttpMethod.GET, entity, String.class);
//        assertNotNull(response);
//    }
//     
//    
//}