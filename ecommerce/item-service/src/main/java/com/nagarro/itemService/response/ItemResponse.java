package com.nagarro.itemService.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemResponse {
	

	
	private String itemId;
	private String itemName;
	private String itemType;
	private String itemDescription;
	private String itemCategory;
	private String itemImageURL;
	private int itemQuantity;



}
