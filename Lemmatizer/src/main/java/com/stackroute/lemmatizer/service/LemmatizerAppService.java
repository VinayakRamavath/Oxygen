package com.stackroute.lemmatizer.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.lemmatizer.domain.LemmatizedQuery;
import com.stackroute.lemmatizer.messenger.Sender;

import ch.qos.logback.core.net.SyslogOutputStream;
import opennlp.tools.lemmatizer.DictionaryLemmatizer;

/*
 * This service performs the work of lemmatization. Two string arrays, one containing the words 
 * of the input sentence and the other containing the parts of speech of the respective words are
 * taken and used to perform lemmatization.
 */

@Service
public class LemmatizerAppService {

	private static Logger logger = LoggerFactory.getLogger(LemmatizerAppService.class);
	
//	Invoking an object of the model class
	
	LemmatizedQuery lemmatizedQuery = new LemmatizedQuery();
	
	@Autowired
	Sender sender;
	
//	Method for lemmatizing the input string
	public LemmatizedQuery lemmatizedString(ArrayList<String> getwords, ArrayList<String> getpos) throws IOException {
		
		
		System.out.println("INSIDE SERVICE");
		System.out.println("WORDS:" +getwords);
		System.out.println("POS:" +getpos);
		
		
		String basePath = new File("").getAbsolutePath();
	    System.out.println("base path : "+basePath);
		
		
//		en-lemmatizer.txt is the lemmatizer file provided by OpenNLP for English lemmatization
		InputStream dictLemmatizer = new FileInputStream(basePath+"/en-lemmatizer.txt");
		
		DictionaryLemmatizer lemmatizer = new DictionaryLemmatizer(dictLemmatizer);
		
		for(int i=0;i<getwords.size();i++) {
			
				if(getpos.get(i).equals("NNP")  ) {
					getpos.set(i,"NN");
				}
			}
		String [] countries = getwords.toArray(new String[getwords.size()]);
		String [] countries1 = getpos.toArray(new String[getpos.size()]);
//		Lemmatizing the input string and storing it
		String[] lemmas = lemmatizer.lemmatize(countries, countries1);
		
		System.out.println("LEMMAS");
		for (String lemma:lemmas)
			System.out.println(lemma);
		
//		logging the output in the console
		logger.info("WORD - POSTAG : LEMMA");
		for(int j=0; j<getwords.size();j++) {
			logger.info(getwords.get(j)+" - "+getpos.get(j)+" : "+lemmas[j]);
		}
		
		lemmatizedQuery.setLemQuery(lemmas);
		
		System.out.println("SET INTO MODEL");
		System.out.println(lemmatizedQuery.getLemQuery());
		return lemmatizedQuery;
	}
}
