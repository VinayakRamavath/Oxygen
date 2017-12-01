package com.stackroute.nlp.kafka;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.nlp.domain.NerModel;
import com.stackroute.nlp.domain.PosModel;
import com.stackroute.nlp.domain.SpellCheckResult;
import com.stackroute.nlp.service.NLPNerService;
import com.stackroute.nlp.service.NLPPosService;
import com.stackroute.nlp.service.StopWordsService;

@Service
public class Listener {
	public final CountDownLatch countDownLatch1 = new CountDownLatch(1);

	@Autowired
	NLPNerService nerservice;

	@Autowired
	NLPPosService nlpposservice;

	@Autowired
	StopWordsService stopWordsService;
	
	@Autowired
	SenderPoS sender;

	@KafkaListener(topics = "spellchecked", containerFactory = "kafkaListenerContainerFactory1")
	public void listen(SpellCheckResult record) throws IOException {

		System.out.println("nermodel is listening");

		PosModel pos=nlpposservice.findPos(record.getSpellcheckresult());
		pos.setQuery(record.getQuery());
		pos.setCorrectedquery(record.getSpellcheckresult());
		System.out.println("query: "+record.getQuery());
		System.out.println("corrected query: "+pos.getCorrectedquery());
		sender.send(pos);
		countDownLatch1.countDown();

	}

	@KafkaListener(topics = "lemmatizer3", containerFactory = "kafkaListenerContainerFactory")
	public void listen(LemmatizedQuery record) throws IOException {
		
		NerModel nm=nerservice.findName(record.getLemQuery());
		
		nm.setQuery(record.getQuery());
		
		nm.setCorrectedquery(record.getCorrectedquery());
	
		sender.sendner(nm);
		

		countDownLatch1.countDown();

	}
}