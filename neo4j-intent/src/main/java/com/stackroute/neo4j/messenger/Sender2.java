package com.stackroute.neo4j.messenger;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.neo4j.domain.Indicator;

@Service
public class Sender2 {
//	
//	
//	@Autowired
//	private KafkaTemplate<String, Collection<Indicator>> kafkaTemplate;
//	
//	private static final Logger LOGGER = LoggerFactory.getLogger(Sender2.class);
//	
//	
//	String kafkaTopic = "neoproducer";
//	
////	public void send(String message) {
////	    kafkaTemplate.send(kafkaTopic, message);
////	}
//	
//	public void sendclass(Collection<Indicator> user) {
////		System.out.println(user[0]);
//		kafkaTemplate.send(kafkaTopic,user);
//	}
}