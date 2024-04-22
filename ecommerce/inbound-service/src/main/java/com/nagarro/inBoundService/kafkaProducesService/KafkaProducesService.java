package com.nagarro.inBoundService.kafkaProducesService;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.nagarro.inBoundService.request.InBoundMessageRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducesService {

	private final KafkaTemplate<String, Object> kafkaTemplate;
	
	public void sendMessage(InBoundMessageRequest inBoundMessageRequest) {
		try {
			
			kafkaTemplate.send("InBoundTopic_Json_Message_1",inBoundMessageRequest);
			log.info("Request receieved successfully " + inBoundMessageRequest.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}
}
