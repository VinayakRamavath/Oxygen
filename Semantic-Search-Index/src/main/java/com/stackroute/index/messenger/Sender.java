package com.stackroute.index.messenger;

import org.apache.log4j.Logger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.index.model.IndexerModel;

@Service
public class Sender {
	
	@Autowired
	private KafkaTemplate<String, IndexerModel> kafkaTemplate;
	
	@Value("${semantic.kafka.topic.producer}")
	String kafkaTopic = "url";
	
	Logger log = Logger.getLogger(getClass());
	
	//send indexermodel to neo4jContentgraph service
	public void send(IndexerModel indexermodel ) {
		log.info("sending message "+indexermodel);
		//System.out.println("sending message"+message);
	    kafkaTemplate.send(kafkaTopic, indexermodel);
	}
}