package com.stackroute.index.messenger;

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

import com.stackroute.index.model.ListIndicator;
import com.stackroute.index.model.ParserModel;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServer;

	@Value("${spring.kafka.consumer.group-id}")
	private String groupId;

	// factory for input data from parser model
	@Bean
	public ConsumerFactory<String, ParserModel> consumerFactory() {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<String, ParserModel>(props, null,
				new JsonDeserializer<ParserModel>(ParserModel.class));
	};

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, ParserModel> kafkaListenerContainerFactory() {

		ConcurrentKafkaListenerContainerFactory<String, ParserModel> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	// factory for input data from neo4j intent graph
	@Bean
	public ConsumerFactory<String, ListIndicator> consumerFactoryneo() {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<String, ListIndicator>(props, null,
				new JsonDeserializer<ListIndicator>(ListIndicator.class));
	};

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, ListIndicator> kafkaListenerContainerFactoryneo() {

		ConcurrentKafkaListenerContainerFactory<String, ListIndicator> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactoryneo());
		return factory;
	}

	@Bean
	public Listener listener() {
		return new Listener();
	}
}
