//package com.stackroute.lemmatizer.service;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertThat;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.embedded.LocalServerPort;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.*;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.stackroute.lemmatizer.LemmatizerApp;
//import com.stackroute.lemmatizer.controller.LemmatizerAppController;
//import com.stackroute.lemmatizer.domain.LemmatizedQuery;
//import com.stackroute.lemmatizer.service.LemmatizerAppService;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = LemmatizerApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class LemmatizerAppServiceTest {
//    String user1;
//    @LocalServerPort
//    private int port;
//    TestRestTemplate restTemplate = new TestRestTemplate();
//    HttpHeaders headers = new HttpHeaders();
//    LemmatizerAppService lemmatizerAppService;
//    
//
//    LemmatizedQuery lemmatizedQuery;
//    
//    @Autowired
//    LemmatizerAppController controller;
//    
//    
////    Creating the before execution and after execution conditions
//     
//    @Before
//    public void setUp() throws Exception {
//    	lemmatizerAppService = new LemmatizerAppService();    
//    }
//    
//    private String createURLWithPort(String uri) {
//        return "http://localhost:" + port + uri;
//    }
//    
//    @After
//    public void tearDown() throws Exception {
//    	lemmatizedQuery = null;
//    }    
//    
////  Check if the controller has initialized or not
//    @Test
//    public void controllerInitialized() {
//    	assertThat(controller).isNotNull();
//    }
//    
////  Checks if the output obtained is correct.
//    @Test
//    public void testIfOutputIsCorrect() throws Exception {
//    	
////    	String[] sentence = new String[]{"The","dogs","were","running","and","barking","down","the","street"};
////        String[] sentencePOS = new String[]{"DT","NNS","VBD","VBG","CC","VBG","RP","DT","NN"};
////        String[] expectedLemma = new String[]{"the","dog","be","run","and","bark","down","the","street"};
////        
////        
////        lemmatizedQuery = lemmatizerAppService.lemmatizedString(sentence, sentencePOS);
////        
////        for(int i=0;i<sentence.length;i++) {
////        	assertEquals(expectedLemma[i], lemmatizedQuery.getLemQuery()[i]);
////        }
//    }
//    
////  Checks if the output obtained is incorrect
//    @Test
//    public void testIfOutputIsIncorrect() throws Exception {
//    	
////    	String[] sentence = new String[]{"The","dogs","were","running","and","barking","down","the","street"};
////        String[] sentencePOS = new String[]{"DT","NNS","VBD","VBG","CC","VBG","RP","DT","NN"};
////        String[] expectedLemma = new String[]{"them","dogs","were","runned","n","barkin","dow","them","streets"};
////        
////        
////        lemmatizedQuery = lemmatizerAppService.lemmatizedString(sentence, sentencePOS);
////        
////        for(int i=0;i<sentence.length;i++) {
////        	assertNotEquals(expectedLemma[i], lemmatizedQuery.getLemQuery()[i]);
////        }
//    }
//}
