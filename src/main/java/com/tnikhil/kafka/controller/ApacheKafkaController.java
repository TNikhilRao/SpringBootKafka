package com.tnikhil.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tnikhil.kafka.producer.Sender;

/**
 * @author Nikhil.Tirmanwar
 *
 */
@RestController
public class ApacheKafkaController {

	@Autowired
	Sender sender;

	@GetMapping("/{message}")
	public void testMe(@PathVariable("message") String message) {

		sender.send(message);

	}
}
