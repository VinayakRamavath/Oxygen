package com.stackroute.Parser.messenger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.stackroute.Parser.Services.ParserServices;
import com.stackroute.Parser.model.CrawlerModel;
import com.stackroute.Parser.model.ParserModel;



@Service
public class Listener {
	
	private ParserModel parserm;
	private String[] keywords;
	
	public ParserModel getParserm() {
		return parserm;
	}

	public void setParserm(ParserModel parserm) {
		this.parserm = parserm;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}
	
	@Autowired
	Sender sender;

//	String[] keywords= {"angular 4","angular-cli","install"};
 	
	ParserServices parserServices =new ParserServices();
	
	
	public final CountDownLatch countDownLatch1 = new CountDownLatch(1);

	
	
//	Listening to crawler produced 
	@KafkaListener(topics = "crawlerproducer",containerFactory = "kafkaListenerContainerFactory")
	public void listen(CrawlerModel record) throws IOException {
		
		System.out.println(record);
		
		ParserModel parsermodel= new ParserModel();
		Map<String,Integer> map= new HashMap<String,Integer>();
		
		
		String[] keywords = getKeywords();
		Document doc = Jsoup.parse(record.getDoc());
		map= parserServices.score(doc, keywords);
		
		
		countDownLatch1.countDown();
		
//		send data to indexer
		parsermodel.setUrl(record.getUrl());
		parsermodel.setDomain(record.getDomain());
		parsermodel.setConcept(record.getConcept());
		parsermodel.setTerms(map);
		parsermodel.setTitle(record.getTitle());
		parsermodel.setSnippet(record.getSnippet());
		
		System.out.println(parsermodel);
		setParserm(parsermodel);
		
		sender.send(parsermodel);

	}
	
	
	
//	Listening to neo4j intent service
	@KafkaListener(topics = "neoproducer",containerFactory = "kafkaListenerContainerFactoryNeo")
	public void listen(String record) throws IOException {
		
		System.out.println(record);

		setKeywords(record.split(","));
		
		countDownLatch1.countDown();
	}








}