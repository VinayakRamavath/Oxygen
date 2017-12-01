//package com.intentgraph.messenger;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//import com.intentgraph.domain.IntentSearchResult;
//
//@Service
//public class Sender {
//    
////  @Autowired
////  private KafkaTemplate<String, String> kafkaTemplate;
//    
//    
//    @Autowired
//    private KafkaTemplate<String, IntentSearchResult> kafkaTemplate1;
//    //private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
//    
//    
//    String kafkaTopic = "conceptsearch";
//    
//    
//    public void send(IntentSearchResult message) {
//        System.out.println("kafka is sending "+message);
//        kafkaTemplate1.send(kafkaTopic,message);
//    }
//}
