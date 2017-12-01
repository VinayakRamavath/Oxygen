package com.stackroute.nlp.config;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.nlp.domain.NERModel;
import com.stackroute.nlp.domain.StopWordsResult;
import com.stackroute.nlp.service.StopWordsService;




@Service
public class ListenerService {

    public final CountDownLatch countDownLatch1 = new CountDownLatch(1);
    
    @Autowired
    StopWordsService stopWordsService;  
    
    @Autowired
    SenderService sender;

    
    @KafkaListener(topics = "nerproducer1")
    public void listen(NERModel record) throws IOException {
    
//        System.out.println(record.getPosmap());
//        System.out.println(record.getUserInput());
    
    
    	String[] keyArray = record.getKeywords().toArray(new String[0]);
    	String[] queryArray = record.getCorrectedquery().split(" ");
    	StopWordsResult swr=stopWordsService.removeStopwords(keyArray, queryArray);
    	
    	swr.setQuery(record.getQuery());
    	swr.setCorrectedquery(record.getCorrectedquery());
    	
    	
        sender.send(swr);
        
        
        countDownLatch1.countDown();
            
        
    }
}
