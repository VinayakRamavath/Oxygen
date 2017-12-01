package com.stackroute.nlp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.nlp.config.SenderService;
import com.stackroute.nlp.domain.StopWords;
import com.stackroute.nlp.domain.StopWordsResult;

@Service
public class StopWordsService {

	StopWords stopWords = new StopWords();
	StopWordsResult stopWordsResult = new StopWordsResult();

	@Autowired
	SenderService sender;

	// remove stopwords
	public StopWordsResult removeStopwords(String[] key, String[] query) {
		// for (String word:pos)
		// System.out.println(word);

		List<String> stopwords = stopWords.getStopWords();

		ArrayList<String> finalkey = new ArrayList<String>();
		ArrayList<String> finalquery = new ArrayList<String>();

		for (String word : key) {
			boolean flag = false;
			for (String stopword : stopwords) {

				if (word.equals(stopword)) {
					flag = true;
					break;
				}

			}
			// System.out.println(flag);
			if (flag == false) {
				finalkey.add(word);
			}

		}
		
		for (String words : query) {
			boolean flag = false;
			for (String stopword : stopwords) {

				if (words.equals(stopword)) {
					flag = true;
					break;
				}

			}
			// System.out.println(flag);
			if (flag == false) {
				finalquery.add(words);
			}

		}

		// System.out.println(finalwords.length);

		System.out.println("FINALKEY");
		for (int x = 0; x < finalkey.size(); x++) {

			System.out.println(finalkey.get(x));

		}
		
		System.out.println("FINALQUERY");
		for (int x = 0; x < finalquery.size(); x++) {

			System.out.println(finalquery.get(x));

		}

		stopWordsResult.setKey(finalkey);
		stopWordsResult.setQueryIntent(finalquery);
		System.out.println("SET INSIDE SERVICE: " + stopWordsResult.getQueryIntent());

		return stopWordsResult;
		// sender.send(stopWordsResult);

	}
}
