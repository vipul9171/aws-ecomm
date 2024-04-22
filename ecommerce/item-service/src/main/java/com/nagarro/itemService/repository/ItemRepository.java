package com.nagarro.itemService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nagarro.itemService.model.Item;

public interface ItemRepository extends MongoRepository<Item, String> {

}
