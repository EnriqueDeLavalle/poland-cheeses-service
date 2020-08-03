package com.epam.polandcheesesservice.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CheeseDTO {

	private String id;
	private String productName;
	private int additivesN;

	public CheeseDTO(@JsonProperty("id") String id, @JsonProperty("product_name") String productName,
			@JsonProperty("additives_n") int additivesN) {
		this.id = id;
		this.productName = productName;
		this.additivesN = additivesN;
	}

	public String getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public int getAdditivesN() {
		return additivesN;
	}

}
