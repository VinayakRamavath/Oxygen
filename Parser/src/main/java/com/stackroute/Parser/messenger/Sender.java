package com.stackroute.Parser.messenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.stackroute.Parser.model.ParserModel;

@Service
public class Sender {
	
	@Autowired
	private KafkaTemplate<String, ParserModel> kafkaTemplate;

	String kafkaTopic = "indexservice";
	
//	send parser object to indexer
	public void send(ParserModel message) {
	    kafkaTemplate.send(kafkaTopic, message);
	}
}