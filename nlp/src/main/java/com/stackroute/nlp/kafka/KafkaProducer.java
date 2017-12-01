package com.stackroute.nlp.kafka;

import java.util.HashMap;

import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.stackroute.nlp.domain.NerModel;
import com.stackroute.nlp.domain.PosModel;
@Configuration
@EnableKafka
public class KafkaProducer  {
	
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServer;

	@Value("${spring.kafka.consumer.group-id}")
	private String groupId;
    
//  @ConditionalOnMissingBean(KafkaProducerConfig.class)
    
    @Bean
  public ProducerFactory<String,PosModel> producerFactory() {
      Map<String, Object> configProps = new HashMap<String, Object>();
      configProps.put(
        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
        bootstrapServer);
      configProps.put(
        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
        StringSerializer.class);
      configProps.put(
        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
        JsonSerializer.class);
      
     return new DefaultKafkaProducerFactory<String,PosModel>(configProps);
  }
 @Bean
  public KafkaTemplate<String, PosModel> kafkaTemplate() {
      return new KafkaTemplate<String, PosModel>(producerFactory());
  }
 
 @Bean
 public ProducerFactory<String,NerModel> producerFactory1() {
     Map<String, Object> configProps = new HashMap<String, Object>();
     configProps.put(
       ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
       bootstrapServer);
     configProps.put(
       ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
       StringSerializer.class);
     configProps.put(
       ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
       JsonSerializer.class);
     
    return new DefaultKafkaProducerFactory<String,NerModel>(configProps);
 }
@Bean
 public KafkaTemplate<String, NerModel> kafkaTemplate1() {
     return new KafkaTemplate<String, NerModel>(producerFactory1());
 }
 
}

