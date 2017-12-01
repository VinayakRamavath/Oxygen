package com.stackroute.lemmatizer.messenger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.lemmatizer.domain.LemmatizedQuery;
import com.stackroute.lemmatizer.domain.StopWordsResult;
import com.stackroute.lemmatizer.service.LemmatizerAppService;

@Service
public class Listener {

	public final CountDownLatch countDownLatch1 = new CountDownLatch(1);

	@Autowired
	Sender sender;

	@Autowired
	LemmatizerAppService lemmatizerAppService;

	@KafkaListener(id = "foo", topics = "posproducer2", group = "group1")
	public void listen(StopWordsResult record) throws IOException {

		System.out.println("Query:" + record.getWords());
		System.out.println("POS:" + record.getPos());
		ArrayList<String> getwords = record.getWords();
		ArrayList<String> getpos = record.getPos();

		LemmatizedQuery result = lemmatizerAppService.lemmatizedString(getwords, getpos);
		result.setQuery(record.getQuery());
		result.setCorrectedquery(record.getCorrectedquery());
		System.out.println("The result is:");
		System.out.println(result.getLemQuery());

		

		sender.send(result);

		countDownLatch1.countDown();

	}
}