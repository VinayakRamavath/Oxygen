package com.stackroute.nlp;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mockito.Spy;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.stackroute.nlp.controller.NLPController;

import junit.framework.TestCase;


/**
 * Unit test for StopWords App.
 */
public class AppTest 
    extends TestCase{
	@Spy
	private NLPController apacheKafkaWebController;
	TestRestTemplate restTemplate = new TestRestTemplate();

	private String createURLWithPort() {
		return "http://localhost:8080";
	}

	@Test
	public void testRemoveStopWords() throws Exception {

//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<NLPController> entity = new HttpEntity<NLPController>(apacheKafkaWebController,
//				headers);
//		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort(), HttpMethod.GET, entity,
//				String.class);
//		assertNotNull(response);

	}
}
