package com.nagarro.inBoundService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nagarro.inBoundService.kafkaProducesService.KafkaProducesService;
import com.nagarro.inBoundService.request.InBoundMessageRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
@Slf4j
public class MessageController {

	private final KafkaProducesService kafkaProducer;

	// http://localhost:8082/api/v1/kafka/publish?message=hello

	/*
	 * @PostMapping("/publish") public ResponseEntity<HttpStatus>
	 * publishMessageToKafka(@RequestParam("message") String message) {
	 * log.info("Message receieved for product name " + message);
	 * kafkaProducer.sendMessage(message); return
	 * ResponseEntity.status(HttpStatus.CREATED).build();
	 * 
	 * }
	 */

	@PostMapping("/publish")
	public ResponseEntity<Object> publishMessageToKafka(@RequestBody InBoundMessageRequest boundRequest) throws JsonProcessingException {
		log.info("Message receieved for product name " + boundRequest.toString());
		kafkaProducer.sendMessage(boundRequest);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}
}
