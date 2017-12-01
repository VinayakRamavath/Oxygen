package com.intentgraph.messenger;

import java.util.concurrent.CountDownLatch;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.intentgraph.controller.IntentController;
import com.intentgraph.domain.ResultModel;

@Service
public class Listener {
	
	@Autowired
	IntentController ic;
	
    public final CountDownLatch countDownLatch1 = new CountDownLatch(1);
    @KafkaListener(id = "foo", topics = "conceptsearch1", group = "group5")
    
    public void listen(ResultModel record) {
    	System.out.println("Intent Service is listening");
    	
    	for (int i=0;i<record.getQuery().length;i++)
    	System.out.println(record.getConcepts()[i]);
    	
    	ic.graph_concept1(record.getQuery());
        countDownLatch1.countDown();
    }
}
