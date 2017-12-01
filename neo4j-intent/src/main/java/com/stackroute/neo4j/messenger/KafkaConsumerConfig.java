
package com.stackroute.neo4j.messenger;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
   
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServer;

	@Value("${spring.kafka.consumer.group-id}")
	private String groupId;
	
   @Bean
   KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, IndexerModel >> kafkaListenerContainerFactory() {
       ConcurrentKafkaListenerContainerFactory<String, IndexerModel> factory = new ConcurrentKafkaListenerContainerFactory<String, IndexerModel>();
       factory.setConsumerFactory(consumerFactory());
       factory.setConcurrency(3);
       factory.getContainerProperties().setPollTimeout(3000);
       return factory;
   }

   @Bean
   public ConsumerFactory<String, IndexerModel> consumerFactory() {
       return new DefaultKafkaConsumerFactory<>(consumerConfigs(),null,new JsonDeserializer<>(IndexerModel.class));
   }

   @Bean
   public Map<String, Object> consumerConfigs() {
       Map<String, Object> propsMap = new HashMap<String, Object>();
       propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
       propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
       propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
       propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
       propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
       propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
       propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
       propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
       return propsMap;
   }

   @Bean
   public Listener listener() {
       return new Listener();
   }
}
