package com.nagarro.itemService.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.itemService.response.ItemResponse;
import com.nagarro.itemService.service.ItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {
	
	private final ItemService itemService;
	
	/*
	 * @PostMapping
	 * 
	 * @ResponseStatus(HttpStatus.CREATED) public void addItem(@RequestBody
	 * ItemRequest itemRequest) { itemService.createItem(itemRequest); }
	 */
	
	@GetMapping("/getAllItems")
	@ResponseStatus(HttpStatus.OK)
	public List<ItemResponse> getAllItem()
	{
		return itemService.getAllItems();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteItem(@PathVariable String id)
	{
		itemService.deleteItem(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
}
