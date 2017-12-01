package com.stackroute.domainexpert.messenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.stackroute.domainexpert.model.DomainExpertModel;

@Service
public class Sender {
	
	@Autowired
	private KafkaTemplate<String, DomainExpertModel> kafkaTemplate;

	String kafkaTopic = "concept";
	
//	send parser object to indexer
	public void send(DomainExpertModel message) {
	    kafkaTemplate.send(kafkaTopic, message);
	}
}