package com.nagarro.itemService.messageConsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.nagarro.inBoundService.request.InBoundMessageRequest;
import com.nagarro.itemService.service.ItemService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaTopicConsumer {
	
	//private final ItemRepository itemRepository;
	
	private final ItemService itemService;
	
	@KafkaListener(topics = "InBoundTopic_Json_Message_1",groupId = "itemGroup")
	public void kafkaConsumer(InBoundMessageRequest consumedRequest)
	{
		try {
			System.out.println("This is kafka consumer");
			log.info("Read String is: "+consumedRequest.toString());
			itemService.createItem(consumedRequest);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}
}
