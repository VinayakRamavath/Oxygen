package com.stackroute.neo4j.messenger;

import java.util.Collection;

//import java.util.HashMap;
//import java.util.Map;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
//
//
//@Configuration
//@EnableKafka
//public class KafkaProducerConfig {
//	@Bean
//	public ProducerFactory<String, String> producerFactory() {
//		return new DefaultKafkaProducerFactory<String, String>(producerConfigs());
//	}
//
//	@Bean
//	public Map<String, Object> producerConfigs() {
//		Map<String, Object> props = new HashMap<String, Object>();
//		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		props.put(ProducerConfig.RETRIES_CONFIG, 0);
//		props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
//		props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
//		props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
//		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//		return props;
//	}
//
//	@Bean
//	public KafkaTemplate<String, String> kafkaTemplate() {
//		return new KafkaTemplate<String, String>(producerFactory());
//	}
//}

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.stackroute.neo4j.domain.Indicator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
@Configuration

public class KafkaProducerConfig2  {
//	@Bean
//    @ConditionalOnMissingBean(name = "KafkaProducerConfig2")
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
//    @ConditionalOnMissingBean(name = "KafkaProducerConfig2")
//    public KafkaTemplate<String, String> kafkaTemplate() {
//        return new KafkaTemplate<String, String>(producerFactory());
//    }
//    
//    
//    @Bean
//    @ConditionalOnMissingBean(name = "KafkaProducerConfig2")
//    public ProducerFactory<String, Collection<Indicator>> producerFactory1() {
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
//        return new DefaultKafkaProducerFactory<String, Collection<Indicator>>(configProps);
//    }
//    
//    @Bean
//    @ConditionalOnMissingBean(name = "KafkaProducerConfig2")
//    public KafkaTemplate<String, Collection<Indicator>> kafkaTemplate1() {
//        return new KafkaTemplate<String, Collection<Indicator>>(producerFactory1());
//    }
}

