package com.javainuse.kafka;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.CountDownLatch;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import com.javainuse.domain.CrawlerModel;
import com.javainuse.domain.Result;
import com.javainuse.domain.SearchResultsModel;
import com.javainuse.service.CrawlerServices;

//@EnableAsync
public class Listener {

	public final CountDownLatch countDownLatch1 = new CountDownLatch(1);
	
	@Autowired
	Sender kafkaSender;
	

	CrawlerServices crawlerservices = new CrawlerServices();
	
	@KafkaListener(topics = "google")
	public void listen(SearchResultsModel  record) throws MalformedURLException, IOException {
		System.out.println(record);

			for(int i=0;i<10;i++) {
				
				Result res = record.getItems().get(i);
				System.out.println(record.getConcept());
				System.out.println(record.getDomain());
				
				System.out.println(res.getLink());
				System.out.println(i+ "   " +res);
				System.out.println(res.getLink());
				System.out.println(res.getSnippet());
				// to retrieve xml page
				Document pageContent = crawlerservices.PageContent(res.getLink());
				CrawlerModel crawlerModel = new CrawlerModel();
				
				crawlerModel.setUrl(res.getLink());
				crawlerModel.setDomain(record.getDomain());
				crawlerModel.setConcept(record.getConcept());
				crawlerModel.setDoc(pageContent.toString());
				crawlerModel.setSnippet(res.getSnippet());
				crawlerModel.setTitle(res.getTitle());
				System.out.println(crawlerModel);
				
				kafkaSender.send(crawlerModel);
				
				System.out.println("data sent to parser");
				
				
			}
			
		}
		
		
		
		
		
	}





