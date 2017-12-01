package com.javainuse.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.javainuse.domain.CrawlerModel;

@Service
public class Sender {
	
	@Autowired
	private KafkaTemplate<String, CrawlerModel> kafkaTemplate;
//	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
	
	
	String kafkaTopic = "crawlerproducer";
//	@Async
	public void send(CrawlerModel message) {

	    kafkaTemplate.send(kafkaTopic, message);
	}
}