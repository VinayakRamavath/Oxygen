package com.stackroute.nlp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.nlp.domain.RemoveStopWords;

@Service
public class StopWordsService {

	
	RemoveStopWords stopWords=new RemoveStopWords();

	public ArrayList<String> remove(ArrayList<String> words) {
		// for (String word:pos)
		// System.out.println(word);

		List<String> stopwords = stopWords.getStopWords();

		ArrayList<String> finalwords = new ArrayList<String>();

		int i = 0,current=0;

		for (String word : words) {
			boolean flag = false;
			System.out.println(i + " " + word);

			for (String stopword : stopwords) {

				if (word.equals(stopword)) {
					flag = true;
					break;
				}

			}
			// System.out.println(flag);
			if (flag == false) {
				finalwords.add(word);

				current++;
			}

			i++;
		}

		System.out.println("FINAL STOP WORDS");
		for (int x = 0; x < finalwords.size(); x++) {

			System.out.println(finalwords.get(x));

		}
		
		return finalwords;
	}
	
	
}
