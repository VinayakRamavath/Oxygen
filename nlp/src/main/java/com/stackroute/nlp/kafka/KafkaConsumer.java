package com.stackroute.nlp.kafka;

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

import com.stackroute.nlp.domain.SpellCheckResult;

@Configuration
@EnableKafka
public class KafkaConsumer {
	
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

	// props,null, new JsonDeserializer<ResultList>(ResultList.class)
	@Bean
	public ConsumerFactory<String, LemmatizedQuery> consumerFactory() {
		return new DefaultKafkaConsumerFactory<String, LemmatizedQuery>(consumerconfigs(), null,
				new JsonDeserializer<LemmatizedQuery>(LemmatizedQuery.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, LemmatizedQuery> kafkaListenerContainerFactory() {

		ConcurrentKafkaListenerContainerFactory<String, LemmatizedQuery> factory = new ConcurrentKafkaListenerContainerFactory<String, LemmatizedQuery>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	@Bean
	public Map<String, Object> consumerconfigs1() {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return props;
	};

	// props,null, new JsonDeserializer<ResultList>(ResultList.class)
	@Bean
	public ConsumerFactory<String, SpellCheckResult> consumerFactory1() {
		return new DefaultKafkaConsumerFactory<String, SpellCheckResult>(consumerconfigs1(), null,
				new JsonDeserializer<SpellCheckResult>(SpellCheckResult.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, SpellCheckResult> kafkaListenerContainerFactory1() {

		ConcurrentKafkaListenerContainerFactory<String, SpellCheckResult> factory = new ConcurrentKafkaListenerContainerFactory<String, SpellCheckResult>();
		factory.setConsumerFactory(consumerFactory1());
		return factory;
	}

}