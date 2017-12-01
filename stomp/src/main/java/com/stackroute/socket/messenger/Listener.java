package com.stackroute.socket.messenger;


import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.stackroute.socket.controller.GreetingController;

public class Listener {
	
	private ListUrls listUrls;

	public ListUrls getListUrls() {
		return listUrls;
	}

	public void setListUrls(ListUrls listUrls) {
		this.listUrls = listUrls;
	}
	
	@Autowired
	GreetingController gc;
	
    @KafkaListener(topics = "neo4j")
    public void listen(ListUrls record) throws Exception  {
    	System.out.println("LISTENING");
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
//    	System.out.println(record.getResult().get(0).getConcept2().getName());
    	System.out.println(record.getQuery());
    	System.out.println(record.getCorrectedquery());
    	setListUrls(record);
    	gc.greetingsend(getListUrls());
    	
    
    	
    }
    
    public ListUrls geturls() {
    	return getListUrls();
    }
   

	
}