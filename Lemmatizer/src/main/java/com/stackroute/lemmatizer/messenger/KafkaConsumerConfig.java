package com.stackroute.lemmatizer.messenger;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.stackroute.lemmatizer.domain.StopWordsResult;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
	
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServer;

	@Value("${spring.kafka.consumer.group-id}")
	private String groupId;

	@Bean
	public Map<String, Object> consumerconfigs() {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return props;
	};

	@Bean
	public ConsumerFactory<String, StopWordsResult> consumerFactory() {
		return new DefaultKafkaConsumerFactory<String, StopWordsResult>(consumerconfigs(), null,
				new JsonDeserializer<StopWordsResult>(StopWordsResult.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, StopWordsResult> kafkaListenerContainerFactory() {

		ConcurrentKafkaListenerContainerFactory<String, StopWordsResult> factory = new ConcurrentKafkaListenerContainerFactory<String, StopWordsResult>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	@Bean
	public Listener listener() {
		return new Listener();
	}

}