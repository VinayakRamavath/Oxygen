package com.stackroute.neo4j.messenger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//{"url":"vinayak","domain":"java","concept":"interface","title":"title","snippet":"snippet","csmap":{"basicscore":54.166666666666664,"examplescore":0.0,"gsscore":0.0,"trscore":0.0,"tsscore":0.0,"tutorialscore":45.83333333333333}}
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.stackroute.neo4j.domain.Concept2;
import com.stackroute.neo4j.domain.IndexerModel;
import com.stackroute.neo4j.domain.IntentSearchResult;
import com.stackroute.neo4j.domain.ListUrls;
import com.stackroute.neo4j.domain.UrlRelation;
import com.stackroute.neo4j.service.UrlService;

public class Listener {

	@Autowired
	UrlService urlService;
	private boolean fake;

	public boolean isFake() {
		return fake;
	}

	@Autowired
	Sender sender;

	public void setFake(boolean fake) {
		this.fake = fake;
	}

	// private IntentSearchResult intentsearchresult;
	// public IntentSearchResult getIntentsearchresult() {
	// return intentsearchresult;
	// }
	//
	// public void setIntentsearchresult(IntentSearchResult intentsearchresult) {
	// this.intentsearchresult = intentsearchresult;
	// }

	private IndexerModel index;

	public IndexerModel getIndex() {
		return index;
	}

	public void setIndex(IndexerModel index) {
		this.index = index;
	}

	public final CountDownLatch countDownLatch1 = new CountDownLatch(1);

	@KafkaListener(topics = "url", containerFactory = "kafkaListenerContainerFactory")
	public void listen(IndexerModel record) {
		// System.out.println("hi");
		// System.out.println(record);
		// System.out.println(record.getUrl());
		setIndex(record);
		UrlRelation urlRelation = urlService.parsenode(getIndex());
		System.out.println(urlRelation.getBasicsscore());
		System.out.println(urlRelation.getConcept2().getName());
		Concept2 concept2 = urlService.findconcept2byname(urlRelation.getConcept2().getName());
		try {
			concept2.getName();
			urlRelation.setConcept2(concept2);
			urlService.postnode(urlRelation);
		} catch (NullPointerException e) {

			urlService.postnode(urlRelation);
		}
		countDownLatch1.countDown();
	}

	@KafkaListener(topics = "nlpresult", containerFactory = "kafkaListenerContainerFactory1")
	public void listen(IntentSearchResult record) {
		this.setFake(false);
		// setIntentsearchresult(record);
		System.out.println(record.getConcept());
		System.out.println(record.getIntent());
		List<UrlRelation> listurls=urlService.getresultsconcepts(record.getConcept(), record.getIntent());
		System.out.println(listurls);
		ArrayList<Double> scores=new ArrayList<Double>();
		for(UrlRelation item:listurls) {
			if(record.getIntent().equals("Basic")){
				System.out.println("inside if");
				scores.add(item.getBasicsscore());
				System.out.println(scores);
			}
			if(record.getIntent().equals("Tutorial")) {
				
				scores.add(item.getTutorialscore());
				System.out.println(scores);
			}
			if(record.getIntent().equals("Getting Started")) {
				scores.add(item.getGettingstartedsscore());
				System.out.println(scores);
			}
			if(record.getIntent().equals("Example")) {
				scores.add(item.getExamplescore());
				System.out.println(scores);
			}
			if(record.getIntent().equals("Complete Reference")) {
				scores.add(item.getCompletereferencesscore());
				System.out.println(scores);
			}
			if(record.getIntent().equals("TroubleShoot")) {
				scores.add(item.getTroubleshootingsscore());
				System.out.println(scores);
			}
		}
		double max=Collections.max(scores);
		System.out.println(max);
		double min=Collections.min(scores);
		System.out.println(min);
		for(double score:scores) {
			if(max!=min)
			score=((score-min)/(max-min))*100;
			else
				score=(score/max)*100;
		}
		
		ListUrls result = new ListUrls(record.getQuery(), record.getCorrectedquery(),record.getConcept(),record.getIntent(),scores,listurls);

		sender.send(result);
		// this.setFake(true);
	}

}
