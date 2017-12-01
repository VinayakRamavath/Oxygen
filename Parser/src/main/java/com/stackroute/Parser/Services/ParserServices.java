package com.stackroute.Parser.Services;

import java.io.IOException;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import com.stackroute.Parser.DataStore.DataStore;


public class ParserServices {
	
	
  Logger  logger = Logger.getLogger(ParserServices.class.getName());
  
	
//	idf values
	int metaidf = 12;
	int titleidf = 9;
	int h1idf=6;
	int h2idf=5;
	int h3idf=4;
	int h4idf=3;
	int h5idf= 2;
	int h6idf=1;
	int pidf=1;
	
	//Data Store instance
	DataStore storeData =new DataStore();

	//Fetch meta-tag score for each keyword

	public void metaScore(Document doc, String[]query) throws IOException {
//		Document doc = Jsoup.connect(url).get();
		String Metakeywords=null;
		 Metakeywords = doc.select("meta[name=keywords]").first().attr("content");

		if(Metakeywords!=null ) {
			for(String temp: query) {
				storeData.setTermScores(temp,0);
				int metakeyscore=0;
				metakeyscore = StringUtils.countMatches(Metakeywords, temp);	//Checking occurrence of the keyword in meta-tag
				int metascore = ( (metakeyscore)*metaidf);	//Fetch the total score of the keyword in meta-tag
				storeData.setTermScores(temp, metascore);	//Add meta-tag score for each keyword in map 
				}
			logger.info("in meta score "+storeData.getMap());
			}
		else {
			return;
		}
	}
	
	//Fetch title-tag score for each keyword
	public void titleScore(Document doc, String[] query) throws IOException {

		String title = doc.title().toLowerCase();
		
		if(title !=null) {
		 for (String temp: query) {
			int titlescore = 0;
			titlescore = (StringUtils.countMatches(title, temp));	//Fetch the total score of the keyword in title-tag
			int count= storeData.getTermScores(temp);	
			storeData.setTermScores(temp,titlescore+count);		//Add title-tag score for each keyword in map 
		}
		 logger.info("in title score " + storeData.getMap());
		}
		else {
			return;
		}
		
	}

	//Fetch h1-tag score for each keyword
	public void h1Score(Document doc, String[] query) throws IOException {

		Elements h1Tags = doc.select("h1");

		if (h1Tags!= null)  {
			for (String temp : query) {
				int h1score = 0;
				h1score = (StringUtils.countMatches(h1Tags.text().toLowerCase(), temp) * h1idf);	//Fetch the total score of the keyword in h1-tag	
				int count= storeData.getTermScores(temp);	
				storeData.setTermScores(temp,count+h1score);	//Add h1-tag score for each keyword in map 			
			}		
			logger.info("in h1 score" + storeData.getMap());		}
		else {
			return;
		} 
	}

	//Fetch h2-tag score for each keyword
	public void h2Score(Document doc, String[] query) throws IOException {

		Elements h2Tags = doc.select("h2");	
		if (h2Tags != null) {
			for (String temp : query) {
				int h2score = 0;
				h2score = (StringUtils.countMatches(h2Tags.text().toLowerCase(), temp) * h2idf);	//Fetch the total score of the keyword in h2-tag
					int count=storeData.getTermScores(temp);	
					storeData.setTermScores(temp,count+h2score);	//Add h2-tag score for each keyword in map
				}
			logger.info("in h2 score"+ storeData.getMap());		}
		else {
			return;
		} 			
	}

	//Fetch h3-tag score for each keyword
	public void h3Score(Document doc, String[] query) throws IOException {

		Elements h3Tags = doc.select("h3");	
		if (h3Tags != null) { 
		for (String temp : query) {
			int h3score = 0;
			h3score = (StringUtils.countMatches(h3Tags.text().toLowerCase(), temp) * h3idf);	//Fetch the total score of the keyword in h3-tag
			int count=storeData.getTermScores(temp);	
			storeData.setTermScores(temp,count+h3score);	//Add h3-tag score for each keyword in map
		}
		logger.info("in h3 score"+storeData.getMap());		}
	else {
		return;
	} 
	}

	
	//Fetch h4-tag score for each keyword
	public void h4Score(Document doc, String[] query) throws IOException {

		Elements h4Tags = doc.select("h4");	
		if (h4Tags != null) {		
		for (String temp : query) {
			int h4score = 0;
			h4score = (StringUtils.countMatches(h4Tags.text().toLowerCase(), temp) * h4idf);	//Fetch the total score of the keyword in h4-tag
			int count=storeData.getTermScores(temp);	
			storeData.setTermScores(temp,count+h4score);	//Add h4-tag score for each keyword in map
		}
		logger.info(storeData.getMap());		}
		else {
			return;
		} 
	}

	//Fetch h5-tag score for each keyword
	public void h5Score(Document doc, String[] query) throws IOException {

		Elements h5Tags = doc.select("h5");	
		if (h5Tags!= null) {
		
		for (String temp : query) {
			int h5score = 0;
			h5score = (StringUtils.countMatches(h5Tags.text().toLowerCase(), temp) * h5idf);	//Fetch the total score of the keyword in h5-tag
			int count=storeData.getTermScores(temp);	
			storeData.setTermScores(temp,count+h5score);	//Add h5-tag score for each keyword in map
		}
		logger.info(storeData.getMap());		}
		else {
			return;
		} 
	}

	//Fetch h6-tag score for each keyword
	public void h6Score(Document doc, String[] query) throws IOException {

		Elements h6Tags = doc.select("h6");	
		if (h6Tags != null) {
		for (String temp : query) {
			int h6score = 0;
			h6score = (StringUtils.countMatches(h6Tags.text().toLowerCase(), temp) * h6idf);	//Fetch the total score of the keyword in h6-tag
			int count=storeData.getTermScores(temp);	
			storeData.setTermScores(temp,count+h6score);	//Add h6-tag score for each keyword in map
		}
		logger.info(storeData.getMap());		}
		else {
			return;
		} 
	}

	//Fetch p-tag score for each keyword
	 public void pScore(Document doc, String[]query) throws IOException {

		 Elements paragraphs = doc.select("p");
		 int pscore=0;
		 if(paragraphs.text()!=null) {
		 for(String temp:query) {
			 pscore+= (StringUtils.countMatches(paragraphs.text().toLowerCase(),temp)*pidf);	//Fetch the total score of the keyword in p-tag
			 int count=storeData.getTermScores(temp);	
				storeData.setTermScores(temp,count+pscore);	//Add p-tag score for each keyword in map
	 }
		 logger.info(storeData.getMap());		 }
		 else {
				return;
			} 
	
	 }
	 
	 
	//calculate scores of each keyword in every tag and add them to map
	public  Map<String,Integer> score(Document doc, String[]keywords ) throws IOException {

		for(String temp: keywords) {
			storeData.setTermScores(temp,0);}
								
//				metaScore(doc, keywords);
				titleScore(doc, keywords);
				h1Score(doc, keywords);
				h2Score(doc, keywords);
				h3Score(doc, keywords);
				h4Score(doc, keywords);
				h5Score(doc, keywords);
				h6Score(doc, keywords);
				pScore(doc, keywords);
				
				logger.info(storeData.getMap());

		return storeData.getMap();
	}

	
}
