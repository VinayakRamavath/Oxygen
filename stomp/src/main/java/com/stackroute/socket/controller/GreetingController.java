package com.stackroute.socket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.stackroute.socket.domain.HelloMessage;
import com.stackroute.socket.messenger.ListUrls;
import com.stackroute.socket.messenger.Listener;
import com.stackroute.socket.messenger.Results;

@Controller

public class GreetingController {

	@Autowired
	Listener listener;

	 @Autowired
	 private SimpMessagingTemplate template;
	
	@CrossOrigin("*")
    @MessageMapping("/hello/{query}")
//    @SendTo("/topic/greetings/{query}")
    public ListUrls greeting(@DestinationVariable("query") String query,HelloMessage message) throws Exception {
        Thread.sleep(5000); // simulated delay
        System.out.println(query);
        System.out.println(message);
        System.out.println("vinayak"+message.getName());
        System.out.println("IN CONTROLLER");
        
        return listener.getListUrls();
    }
    

    public ListUrls greetingsend(ListUrls listurls) throws Exception {

        Thread.sleep(1000); // simulated delay
    	System.out.println("INSIDE GREETINGSEND");
        System.out.println(listurls);
        this.template.convertAndSend("/topic/greetings/"+listurls.getQuery().trim(), listurls);
        System.out.println("/topic/greetings/"+listurls.getQuery());
        boolean b=("/topic/greetings/"+listurls.getQuery().trim()).equals("/topic/greetings/what is interface");
        System.out.println("equal= "+b);
        System.out.println("before return");
        return listurls;

    }

}
