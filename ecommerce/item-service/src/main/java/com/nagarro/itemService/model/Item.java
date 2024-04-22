package com.nagarro.itemService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(value="item")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Item {
	
	@Id
	private String itemId;
	@Field(name="Item-Name")
	private String itemName;
	@Field(name="item-type")
	private String itemType;
	@Field(name="item-description")
	private String itemDescription;
	@Field(name="item-category")
	private String itemCategory;
	@Field(name="item-imageURL")
	private String itemImageURL;
	@Field(name="item-quantity")
	private int itemQuantity;

}
