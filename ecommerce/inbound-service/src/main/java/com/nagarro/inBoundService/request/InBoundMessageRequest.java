package com.nagarro.inBoundService.request;

import lombok.Data;

@Data
public class InBoundMessageRequest {


	private String id;
	private String productName;
	private String productDescription;
	private String productImageURL;
	private int productQuantity;
	private String productCategory;



}
