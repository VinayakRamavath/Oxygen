package com.diksha.spellcheck.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.diksha.spellcheck.domain.SpellCheckResult;


@Service
public class Sender {
//    
  @Autowired
  private KafkaTemplate<String, SpellCheckResult> kafkaTemplate;

    //private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
   
    
   String kafkaTopic = "spellchecked";
    
    
    public void send(SpellCheckResult message) {
        System.out.println("kafka is sending "+message.getSpellcheckresult());
        System.out.println("query "+message.getQuery());
        kafkaTemplate.send(kafkaTopic,message);
    }
}
