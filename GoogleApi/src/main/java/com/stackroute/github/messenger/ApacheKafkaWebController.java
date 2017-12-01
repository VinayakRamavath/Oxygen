package com.stackroute.github.messenger;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.github.domain.SearchResultsModel;



@RestController
public class ApacheKafkaWebController {

	@Autowired
	Sender kafkaSender;
	
	@Autowired
	private KafkaTemplate<String,SearchResultsModel> kafkaTemplate;

//	@RequestMapping()
//	public ResponseEntity<?> getOneResults() {
//		kafkaSender.send("heya");
//		return new ResponseEntity<String>("heya", HttpStatus.OK);
//	}
	
//	@GetMapping(value = "/producer")
//	public String producer(@RequestParam("message") String message) {
//		kafkaSender.send(message);
//
//		return "Message sent to the Kafka Topic java_in_use_topic Successfully";
//	}

}