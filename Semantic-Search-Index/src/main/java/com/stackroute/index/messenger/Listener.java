package com.stackroute.index.messenger;

import java.util.Collection;
import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.stackroute.index.exception.NoInputException;
import com.stackroute.index.model.IndexerModel;
import com.stackroute.index.model.Indicator;
import com.stackroute.index.model.ListIndicator;
import com.stackroute.index.model.ParserModel;
import com.stackroute.index.service.IndexService;

public class Listener {
	Logger log = Logger.getLogger(getClass());

	@Autowired
	IndexService indexservice;

	@Autowired
	private IndexerModel indexermodel;

	Collection<Indicator> termweight;

	public Collection<Indicator> getTermweight() {
		return termweight;
	}

	public void setTermweight(Collection<Indicator> termweight) {
		this.termweight = termweight;
	}

	@Autowired
	Sender sender;

	public final CountDownLatch countDownLatch1 = new CountDownLatch(1);

	// public final CountDownLatch countDownLatch2 = new CountDownLatch(2);

	// listen term score for intent from parser
	@KafkaListener(topics = "${semantic.kafka.topic.consumer1}", containerFactory = "kafkaListenerContainerFactory")
	public void listen(ParserModel record) throws NoInputException {

		log.info("Received Data " + record);

		log.info("Url : " + record.getUrl());
		log.info("domain : " + record.getDomain());
		log.info("concept : " + record.getConcept());
		log.info("title : " + record.getTitle());
		log.info("snippet : " + record.getSnippet());
		log.info("map : " + record.getTerms());

		indexermodel.setUrl(record.getUrl());
		indexermodel.setDomain(record.getDomain());
		indexermodel.setConcept(record.getConcept());
		indexermodel.setTitle(record.getTitle());
		indexermodel.setSnipet(record.getSnippet());

		// while(termweight==null)
		// {
		//
		// }

		indexermodel.setCsmap(indexservice.getScore(record.getTerms(), termweight));

		log.info("output: " + indexermodel.getCsmap());

		sender.send(indexermodel);

		countDownLatch1.countDown();
	}

	// get intent term weight for neo4j intent graph
	@KafkaListener(topics = "${semantic.kafka.topic.consumer2}", containerFactory = "kafkaListenerContainerFactoryneo")
	public void listen(ListIndicator record) {

		log.info("Received Data " + record);

		Indicator temp = record.getListindicator().iterator().next();

		log.info("record id : " + temp.getId());
		log.info("record weight : " + temp.getWeight());

		setTermweight(record.getListindicator());

		// if(indexermodel.getTitle()!=null)
		// {
		//
		// }
	}
}
