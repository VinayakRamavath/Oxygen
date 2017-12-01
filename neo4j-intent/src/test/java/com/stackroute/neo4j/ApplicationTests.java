package com.stackroute.neo4j;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.neo4j.Application;
import com.stackroute.neo4j.domain.Heading;
import com.stackroute.neo4j.domain.Indicator;
import com.stackroute.neo4j.domain.Intent;
import com.stackroute.neo4j.domain.Level;
import com.stackroute.neo4j.domain.Terms;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests  extends TestCase {
   
	@LocalServerPort
	private int port;
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	Indicator user;
	Terms concept1;
	Level concept2;
	Heading heading;
	Intent user1;
    
	@Before
    public void setUp() throws Exception {
		concept1=new Terms("concept1");
		concept2=new Level("concept2");
		heading=new Heading("hi");
		float i=1;
		user = new Indicator(i,concept1,concept2);
		user1=new Intent(concept2,heading);
    }
	
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + "/v1.0/semantic/neo4jintentservice" + uri;
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testLevel() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/graphlevel/concept2"),
                HttpMethod.GET, entity, String.class);
        assertNotNull(response);
    }
    
    @Test
    public void testSaveUserWithoutNamecounter() throws Exception {
//    	String actual = ""; 
//    	HttpHeaders headers = new HttpHeaders();
//	    headers.setContentType(MediaType.APPLICATION_JSON);
//	    HttpEntity<Indicator> entity = new HttpEntity<Indicator>(user, headers); 
//	    ResponseEntity<String> response = restTemplate.exchange(
//	             createURLWithPort("/postcounter"),
//	             HttpMethod.POST, entity, String.class); 
//	    assertNotNull(response);
//	    actual = response.getBody();
//    	 
//        assertEquals("node saved",actual); 
        
    }
    
    @Test
    public void testHeading() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/graphheading/concept2"),
                HttpMethod.GET, entity, String.class);
        assertNotNull(response);
    }
    
    @Test
    public void testSaveUserWithoutNameintentr() throws Exception {
//    	String actual = ""; 
//    	HttpHeaders headers = new HttpHeaders();
//	    headers.setContentType(MediaType.APPLICATION_JSON);
//	    HttpEntity<Intent> entity = new HttpEntity<Intent>(user1, headers); 
//	    ResponseEntity<String> response = restTemplate.exchange(
//	             createURLWithPort("/postintent"),
//	             HttpMethod.POST, entity, String.class); 
//	    assertNotNull(response);
//	    actual = response.getBody();
//    	 
//        assertEquals("node saved",actual); 
        
    }
}