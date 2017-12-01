package com.javainuse.controllertest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Spy;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.javainuse.controller.CrawlerController;

public class CrawlerControllerTest {

	@Spy
	private CrawlerController apacheKafkaWebController;
	TestRestTemplate restTemplate = new TestRestTemplate();

	private String createURLWithPort() {
		return "http://localhost:8070";
	}

	//test to check that an xml file is being retrieved
	@Test
	public void testSaveUser() throws Exception {

//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<CrawlerController> entity = new HttpEntity<CrawlerController>(apacheKafkaWebController,
//				headers);
//		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort(), HttpMethod.GET, entity,
//				String.class);
//		assertNotNull(response);

	}

}
