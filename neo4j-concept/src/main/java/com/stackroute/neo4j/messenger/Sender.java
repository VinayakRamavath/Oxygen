package com.stackroute.neo4j.messenger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.neo4j.domain.ListUrls;
import com.stackroute.neo4j.domain.ProducerDomain;

@Service
public class Sender {

	@Autowired
	private KafkaTemplate<String, ListUrls> kafkaTemplate;
	@Autowired
	private KafkaTemplate<String, ProducerDomain> kafkaTemplate1;
	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

	String kafkaTopic = "concept";
	String kafkaTopic1 = "neo4j";

	// public void send(String message) {
	// kafkaTemplate.send(kafkaTopic, message);
	// }

	public void sendclass(ProducerDomain user) {
		kafkaTemplate1.send(kafkaTopic, user);
	}

	public void send(ListUrls resultss) {
		System.out.println("neo4j is sending to socket");
		kafkaTemplate.send(kafkaTopic1, resultss);
	}
}