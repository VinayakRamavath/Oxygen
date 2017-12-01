package com.stackroute.nlp.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Service;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.NameSampleDataStream;

import opennlp.tools.namefind.TokenNameFinderFactory;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.MarkableFileInputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

import opennlp.tools.util.TrainingParameters;

@Service
public class NameFinderTrainUtil {

	public static void namefindertrain() {

		// reading training data
		InputStreamFactory in = null;
		try {
			String basePath = new File("").getAbsolutePath();
			System.out.println("base path : " + basePath);
			//in = new MarkableFileInputStreamFactory(new File(basePath+"/input.txt"));
			in = new MarkableFileInputStreamFactory(new File(basePath+"/FinanceOutpuutt.txt"));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		
	    ObjectStream sampleStream = null;
		try {
			sampleStream = new NameSampleDataStream(
	            new PlainTextByLineStream(in, StandardCharsets.UTF_8));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// setting the parameters for training
	    TrainingParameters params = new TrainingParameters();
	    params.put(TrainingParameters.ITERATIONS_PARAM, 70);
	    params.put(TrainingParameters.CUTOFF_PARAM, 1);

	    // training the model using TokenNameFinderModel class 
	    TokenNameFinderModel nameFinderModel = null;
		try {
			
			nameFinderModel = NameFinderME.train("en", null, sampleStream,
			    params, new TokenNameFinderFactory());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// saving the model to "ner-custom-model.bin" file
		try {
			String basePath = new File("").getAbsolutePath();
			System.out.println("base path : " + basePath);
			
			//File output = new File(basePath+"/ner-custom-model.bin");
			File output = new File(basePath+"/ner-custom-model-finance.bin");
			FileOutputStream outputStream = new FileOutputStream(output);
			nameFinderModel.serialize(outputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}