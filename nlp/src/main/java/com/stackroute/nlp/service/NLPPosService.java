package com.stackroute.nlp.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.nlp.domain.PosModel;
import com.stackroute.nlp.kafka.SenderPoS;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

@Service
public class NLPPosService implements NLPPos {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// finding Parts_Of_Speech
	PosModel posmodel = new PosModel();



	public  PosModel findPos(String sentence) {

		String[] words = new String[20];
		String[] pos = new String[20];

		InputStream tokenModelIn = null;
		InputStream posModelIn = null;
		try {
			// String sentence = "What is Anonymous Inner Class in Java";
			// tokenize the sentence

			String basePath = new File("").getAbsolutePath();
			System.out.println("base path : " + basePath);

			tokenModelIn = new FileInputStream(basePath + "/en-token.bin");
			TokenizerModel tokenModel = new TokenizerModel(tokenModelIn);
			Tokenizer tokenizer = new TokenizerME(tokenModel);
			String tokens[] = tokenizer.tokenize(sentence);

			// Parts-Of-Speech Tagging
			// reading parts-of-speech model to a stream
			posModelIn = new FileInputStream(basePath + "/en-pos-maxent.bin");
			// loading the parts-of-speech model from stream
			POSModel posModel = new POSModel(posModelIn);
			// initializing the parts-of-speech tagger with model
			POSTaggerME posTagger = new POSTaggerME(posModel);
			// Tagger tagging the tokens
			String tags[] = posTagger.tag(tokens);
			// Getting the probabilities of the tags given to the tokens
			double probs[] = posTagger.probs();

			Map<String, String> posmap = new HashMap<String, String>();
			System.out.println("Token\t:\tTag\t:\tProbability\n---------------------------------------------");
			for (int i = 0; i < tokens.length; i++) {

				logger.info(tokens[i] + "\t:\t" + tags[i] + "\t:\t" + probs[i]);

			}

			posmodel.setPos(tags);
			posmodel.setWords(tokens);
			
			//sender.send(posmodel);

		} catch (IOException e) {
			// Model loading failed, handle the error
			e.printStackTrace();
		} finally {
			if (tokenModelIn != null) {
				try {
					tokenModelIn.close();
				} catch (IOException e) {
				}
			}
			if (posModelIn != null) {
				try {
					posModelIn.close();
				} catch (IOException e) {
				}
			}
		}
		return posmodel;
		
	}
	
}
