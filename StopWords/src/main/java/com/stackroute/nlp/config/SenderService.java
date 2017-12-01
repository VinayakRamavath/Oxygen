package com.stackroute.nlp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.nlp.domain.StopWordsResult;

@Service
public class SenderService {

	@Autowired
	private KafkaTemplate<String, StopWordsResult> kafkaTemplate;
	// private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

	String kafkaTopic = "stopwords1";

	// @Async
	public void send(StopWordsResult message) {
		
		System.out.println("stopwords is sending");
		System.out.println("Key: " +message.getKey());
    	System.out.println("Query: "+message.getQuery());
    	System.out.println("corrected query: "+message.getCorrectedquery());
		

		kafkaTemplate.send(kafkaTopic, message);


	}
}
