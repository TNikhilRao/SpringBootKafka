package com.tnikhil.kafka.consumer;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * @author Nikhil.Tirmanwar
 *
 */
@Service
public class Receiver {

	private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);
	
	public CountDownLatch countDownLatch0 = new CountDownLatch(3);

	@KafkaListener(id = "id0", topicPartitions = { @TopicPartition(topic = "mytest-topic", partitions = { "0" }) })
	//@KafkaListener(topics = "${app.topic.foo}")
	public void listen(@Payload String message) { //ConsumerRecord<?, ?> record ) {
		LOG.info("received message='{}'", message);
		//System.out.println("Listener Id0, Thread ID: " + Thread.currentThread().getId());
		System.out.println("Received: " + message);
		countDownLatch0.countDown();
	}

}
