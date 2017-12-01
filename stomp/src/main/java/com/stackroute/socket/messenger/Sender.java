package com.stackroute.socket.messenger;
//package hello.messenger;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class Sender {
//	
//	@Autowired
//	private KafkaTemplate<String, String> kafkaTemplate;
//	@Autowired
//	private KafkaTemplate<String, ProducerDomain> kafkaTemplate1;
//	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
//	
//	
//	String kafkaTopic = "concept";
//	
////	public void send(String message) {
////	    kafkaTemplate.send(kafkaTopic, message);
////	}
//	
//	public void sendclass(ProducerDomain user) {
//		kafkaTemplate1.send(kafkaTopic,user);
//	}
//}