//package com.intentgraph.messenger;
//
//import java.util.HashMap;
//import java.util.Map;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import com.intentgraph.domain.IntentSearchResult;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//@Configuration
//public class KafkaProducerConfig  {
//    @Bean
//    public ProducerFactory<String, String> producerFactory() {
//        Map<String, Object> configProps = new HashMap<String, Object>();
//        configProps.put(
//          ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, 
//          "172.23.238.178:9092");
//        configProps.put(
//          ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, 
//          StringSerializer.class);
//        configProps.put(
//          ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, 
//          JsonSerializer.class);
//        return new DefaultKafkaProducerFactory<String, String>(configProps);
//    }
// 
//    @Bean
//    public KafkaTemplate<String, String> kafkaTemplate() {
//        return new KafkaTemplate<String, String>(producerFactory());
//    }
//    
//    
//    @Bean
//    public ProducerFactory<String, IntentSearchResult> producerFactory1() {
//        Map<String, Object> configProps = new HashMap<String, Object>();
//        configProps.put(
//          ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, 
//          "172.23.238.178:9092");
//        configProps.put(
//          ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, 
//          StringSerializer.class);
//        configProps.put(
//          ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, 
//          JsonSerializer.class);
//        return new DefaultKafkaProducerFactory<String, IntentSearchResult>(configProps);
//    }
//    
//    @Bean
//    public KafkaTemplate<String, IntentSearchResult> kafkaTemplate1() {
//        return new KafkaTemplate<String, IntentSearchResult>(producerFactory1());
//    }
//}
