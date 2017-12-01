package com.stackroute.neo4j.messenger;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.neo4j.domain.ListIndicator;

@Service
public class Sender {
	
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private KafkaTemplate<String, ListIndicator> kafkaTemplate1;
	
	private static final Logger log = LoggerFactory.getLogger(Sender.class);
	
	@Value("${semantic.kafka.topic.producer2}")
	String kafkaTopic;
	
	@Value("${semantic.kafka.topic.producer1}")
	String kafkaTopic1;
	
//	public void send(String message) {
//	    kafkaTemplate.send(kafkaTopic, message);
//	}
	
	public void sendclass(String user) {
//		System.out.println(user[0]);
		kafkaTemplate.send(kafkaTopic,user);
	}
	
	public void sendclass(ListIndicator user) {
//		System.out.println(user[0]);
		kafkaTemplate1.send(kafkaTopic1,user);
	}
}