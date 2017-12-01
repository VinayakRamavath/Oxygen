//package com.stackroute.neo4j.controller;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.context.embedded.LocalServerPort;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.*;
//import org.springframework.test.context.junit4.SpringRunner;
//import com.stackroute.neo4j.Application;
//import com.stackroute.neo4j.domain.Concept1;
//import com.stackroute.neo4j.domain.Concept2;
//import com.stackroute.neo4j.domain.Subconcept;
//import com.stackroute.neo4j.service.SubconceptService;
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class TestController {
//    
//    String user1;
//    @LocalServerPort
//    private int port;
//    TestRestTemplate restTemplate = new TestRestTemplate();
//    HttpHeaders headers = new HttpHeaders();
//    SubconceptService subconceptService;
//    Subconcept subconcept;
//    Concept1 concept1;
//    Concept2 concept2;
//    @Before
//    public void setUp() throws Exception {
//         
//        concept1= new Concept1();
//        concept1.setId((long) 4);
//        concept1.setName("Abstraction");
//        concept1.setContext("Java software programming");
//        concept1.setDescription("Abstraction: Java software programming: Web programming");
//        
//        concept2 = new Concept2();
//        concept2.setId((long) 2);
//        concept2.setName("one-to-many");
//        concept2.setContext("Java Hibernate");
//        concept2.setDescription("one-to-many: Java Hibernate: Web programming");
//        
//        subconcept = new Subconcept(user1, concept1,concept2);
//        subconcept.setName(null);
//    }
//    
//    private String createURLWithPort(String uri) {
//        return "http://localhost:" + port + uri;
//    }
//    
//    @After
//    public void tearDown() throws Exception {
//    }
//    
//    @Test
//    public void testSaveUser() throws Exception {
//        HttpEntity<Subconcept> entity = new HttpEntity<Subconcept>(subconcept, headers);
//        ResponseEntity<Subconcept> response = restTemplate.exchange(
//                createURLWithPort("/postcsvsubconcept"),
//                HttpMethod.POST, entity, Subconcept.class);
//        assertNotNull(response);
//        Subconcept actual = response.getBody();
//        assertEquals(subconcept.getName(),actual.getName());
//    }
//    
//    @Test
//    public void testList() throws Exception {
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort("/postsubconcept"),
//                HttpMethod.GET, entity, String.class);
//        assertNotNull(response);
//    }
//    
//}