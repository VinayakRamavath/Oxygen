package com.stackroute.lemmatizer.messenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.lemmatizer.domain.LemmatizedQuery;

@Service
public class Sender {

	@Autowired
	private KafkaTemplate<String, LemmatizedQuery> kafkaTemplate;
	
	String kafkaTopic="lemmatizer3";

	
	public void send(LemmatizedQuery message) {
		kafkaTemplate.send(kafkaTopic, message);
		System.out.print("lemmatizer is sending: ");
		
		String[] words=message.getLemQuery();

		for (String word:words)
		System.out.println(word);
		
		System.out.println("QUERY: "+message.getQuery());
		System.out.println("CORRECTED QUERY: "+message.getCorrectedquery());
	}
}