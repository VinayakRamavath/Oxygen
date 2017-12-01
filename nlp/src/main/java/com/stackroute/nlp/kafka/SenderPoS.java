package com.stackroute.nlp.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.nlp.domain.NerModel;
import com.stackroute.nlp.domain.PosModel;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class SenderPoS {

	@Autowired
	private KafkaTemplate<String, PosModel> kafkaTemplate;

	String kafkaTopic = "posproducer2";

	@Autowired
	private KafkaTemplate<String, NerModel> kafkaTemplate1;

	String kafkaTopic1 = "nerproducer1";

	public void send(PosModel posmodel) {

		System.out.println("PoS Model is sending: ");
		System.out.println(posmodel.getWords());
		System.out.println(posmodel.getPos());
		
		System.out.println("QUERY: "+posmodel.getQuery());
		System.out.println("CORRECTED QUERY: "+posmodel.getCorrectedquery());
		kafkaTemplate.send(kafkaTopic, posmodel);

	}

	public void sendner(NerModel nermodel) {

		System.out.print("Ner model is sending: ");

		System.out.println("keywords" + nermodel.getKeywords());
		System.out.println("query" + nermodel.getWords());
		System.out.println("QUERY: "+nermodel.getQuery());
		System.out.println("CORRECTED QUERY: "+nermodel.getCorrectedquery());
		kafkaTemplate1.send(kafkaTopic1, nermodel);
		System.out.println("ner model data sent");

	}

}
