package com.intentgraph.messenger;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.intentgraph.domain.IntentSearchResult;
import com.intentgraph.domain.StopWordsResult;
import com.intentgraph.service.SameAsInterface;

@Service
public class Listener {

	@Autowired
	SameAsInterface sameAsService;
	
	@Autowired
	Sender sender;

	public final CountDownLatch countDownLatch1 = new CountDownLatch(1);

	@KafkaListener(topics = "stopwords1")
	public void listen(StopWordsResult record) {
		System.out.println("Intent Service is listening");

		// for (int i=0;i<record.getQuery().length;i++)
		// System.out.println(record.getConcepts()[i]);
		//
		// String[] query= {"define", "interface"};
		String words = "";
		IntentSearchResult intentSearchResult = new IntentSearchResult();
		String intent = "default";

		for (int i = 0; i < record.getQueryIntent().size(); i++) {
			System.out.println("QUERY INTENT");
			System.out.println(record.getQueryIntent().get(i));
			words = record.getQueryIntent().get(i);
			try {
				System.out.println(words);
				intent = sameAsService.findquerybyname(words);
				
				System.out.println("intent : " + intent);

			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
			}
		}
		if (intent == "default")
			intent = "Basic";

		intentSearchResult.setIntent(intent);
		
		String concept = "";
		ArrayList<String> keywords = record.getKey();
		
		for (int anj = 0; anj < record.getKey().size(); anj++) {
			System.out.println(keywords.get(anj));
			concept += keywords.get(anj) + " ";
		}
		intentSearchResult.setConcept(concept);
		System.out.println("INTENT FOUND: " + intent);
		System.out.println("CONCEPT FOUND: " + concept);
		
		intentSearchResult.setQuery(record.getQuery());
		intentSearchResult.setCorrectedquery(record.getCorrectedquery());
		System.out.println("INSIDE LISTENER");
		
		System.out.println(intentSearchResult.getQuery());
		System.out.println(intentSearchResult.getCorrectedquery());
		
		
		sender.send(intentSearchResult);
		System.out.println("intent search result has been sent");
		countDownLatch1.countDown();
	}
}
