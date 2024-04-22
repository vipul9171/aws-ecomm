package com.nagarro.itemService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.inBoundService.request.InBoundMessageRequest;
import com.nagarro.itemService.model.Item;
import com.nagarro.itemService.repository.ItemRepository;
import com.nagarro.itemService.response.ItemResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService {

	private final ItemRepository itemRepository;

	public void createItem(InBoundMessageRequest messageRequest) {
		Item item = Item.builder().itemId(messageRequest.getId()).itemName(messageRequest.getProductName())
				.itemDescription(messageRequest.getProductDescription())
				.itemQuantity(messageRequest.getProductQuantity()).itemCategory(messageRequest.getProductCategory())
				.itemImageURL(messageRequest.getProductImageURL()).build();

		itemRepository.save(item);
		log.info("Item {} Saved successfully", item.toString());
	}

	public List<ItemResponse> getAllItems() {
		List<Item> items = itemRepository.findAll();

		return items.stream().map(this::mapToItemResponse).toList();

	}

	private ItemResponse mapToItemResponse(Item item) {

		return ItemResponse.builder().itemId(item.getItemId()).itemDescription(item.getItemDescription())
				.itemName(item.getItemName()).itemType(item.getItemType()).itemQuantity(item.getItemQuantity())
				.itemCategory(item.getItemCategory()).itemImageURL(item.getItemImageURL()).build();
	}

	public void deleteItem(String id) {
		itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Passed Id Not present in the Database"));
		itemRepository.deleteById(id);
	}

}
