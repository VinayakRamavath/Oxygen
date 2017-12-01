package com.stackroute.Parser.messenger;

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
import com.stackroute.Parser.model.CrawlerModel;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
	
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServer;

	@Value("${spring.kafka.consumer.group-id}")
	private String groupId;
	
//	Crawler object consumer factory
	@Bean
	public ConsumerFactory<String, CrawlerModel> consumerFactory() {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<String, CrawlerModel>(props, null,
				new JsonDeserializer<CrawlerModel>(CrawlerModel.class));
	};

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, CrawlerModel> kafkaListenerContainerFactory() {

		ConcurrentKafkaListenerContainerFactory<String, CrawlerModel> factory = new ConcurrentKafkaListenerContainerFactory<String, CrawlerModel>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	// @Bean
	// public Listener listener() {
	// return new Listener();
	// }

	
//	Neo4j intent graph consumer factory
	@Bean
	public ConsumerFactory<String, String> consumerFactoryNeo() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<String, String>(props);
	};

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactoryNeo() {

		ConcurrentKafkaListenerContainerFactory<String, String> factoryneo = new ConcurrentKafkaListenerContainerFactory<>();
		factoryneo.setConsumerFactory(consumerFactoryNeo());
		return factoryneo;
	}

}