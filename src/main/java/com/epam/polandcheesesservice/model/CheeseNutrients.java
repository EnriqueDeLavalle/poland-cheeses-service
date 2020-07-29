package com.epam.polandcheesesservice.model;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CheeseNutrients {

	private String id;
	private String productName;
	private HashMap<?, ?> nutriments;

	public CheeseNutrients() {
		super();
	}

	public CheeseNutrients(@JsonProperty("id") String id, @JsonProperty("product_name") String productName,
			@JsonProperty("nutriments") HashMap<?, ?> nutriments) {
		super();
		this.id = id;
		this.productName = productName;
		this.nutriments = nutriments;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public HashMap<?, ?> getNutriments() {
		return nutriments;
	}

	public void setNutriments(HashMap<?, ?> nutriments) {
		this.nutriments = nutriments;
	}

}
