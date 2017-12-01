
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
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.stackroute.neo4j.domain.IndexerModel;
import com.stackroute.neo4j.domain.IntentSearchResult;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServer;

	@Value("${spring.kafka.consumer.group-id}")
	private String groupId;

	@Bean
	public ConsumerFactory<String, IndexerModel> consumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<String, IndexerModel>(props, null,
				new JsonDeserializer<IndexerModel>(IndexerModel.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, IndexerModel> kafkaListenerContainerFactory() {

		ConcurrentKafkaListenerContainerFactory<String, IndexerModel> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	@Bean
	public ConsumerFactory<String, IntentSearchResult> consumerFactory1() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		props.put(ConsumerConfig.GROUP_ID_CONFIG,groupId );
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<String, IntentSearchResult>(props, null,
				new JsonDeserializer<IntentSearchResult>(IntentSearchResult.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, IntentSearchResult> kafkaListenerContainerFactory1() {

		ConcurrentKafkaListenerContainerFactory<String, IntentSearchResult> factory1 = new ConcurrentKafkaListenerContainerFactory<>();
		factory1.setConsumerFactory(consumerFactory1());
		return factory1;
	}

	@Bean
	public Listener listener() {
		return new Listener();
	}

}
