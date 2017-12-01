package com.stackroute.neo4j.messenger;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class Listener {

	public final CountDownLatch countDownLatch1 = new CountDownLatch(1);

//	@KafkaListener(topics = "${semantic.kafka.topic.consumer}")
//	public void listen(IndexerModel record) {
//		System.out.println(record);
//		System.out.println(record.getUrl());
//		
//		countDownLatch1.countDown();
//	}
}