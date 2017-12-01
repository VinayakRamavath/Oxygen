package com.stackroute.nlp.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.nlp.domain.NerModel;
import com.stackroute.nlp.kafka.SenderPoS;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

@Service
public class NLPNerService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());



	@Autowired
	StopWordsService stopWordsService;

	@Autowired
	SenderPoS sender;

	NerModel nermodel = new NerModel();

	public NerModel findName(String[] words) throws IOException {

		String temp = "";

		for (String word : words)
			temp += word + " ";

		temp = temp.trim();

		

			System.out.println("WORDS" + words.length);

			for (String word : words) {
				System.out.println(word);
			}

			String basePath = new File("").getAbsolutePath();
			System.out.println("base path : " + basePath);

			// InputStream is = new FileInputStream("ner-custom-model.bin");
			//InputStream is = new FileInputStream(basePath + "/ner-custom-model.bin");
			InputStream is = new FileInputStream(basePath + "/ner-custom-model-finance.bin");

			// load the model from file
			TokenNameFinderModel model = new TokenNameFinderModel(is);
			is.close();

			// feed the model to name finder class
			NameFinderME nameFinder = new NameFinderME(model);

			// String[] result=new String[words.length];
			ArrayList<String> result = new ArrayList<String>();
			Span nameSpans[] = null;
			for (int i = 0; i < words.length; i++) {
				nameSpans = nameFinder.find(words);
			}

			// nameSpans contain all the possible entities detected
			int start = 0, end = 0;
			for (Span s : nameSpans) {
				logger.info(s.toString());
				logger.info("  :  ");

				start = s.getStart();
				end = s.getEnd();
				System.out.println(s.getStart());
				System.out.println(s.getEnd());

			}
			// s.getStart() : contains the start index of possible name in the input string
			// array
			// s.getEnd() : contains the end index of the possible name in the input string
			// array
			for (int index = start; index < end; index++) {
				result.add(words[index]);

				// logger.info("RESULT");
				// logger.info(result.get(index)+" ");
			}

			for (int i1 = 0; i1 < result.size(); i1++)
				logger.info(result.get(i1));

			// ArrayList<String> keywords=stopWordsService.remove(result);

			nermodel.setKeywords(result);
			ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(words));

			nermodel.setWords(arrayList);

			System.out.println("INSIDE SERVICE");

			System.out.println(nermodel.getKeywords());
			System.out.println(nermodel.getWords());
			return nermodel;
		

	}

}
