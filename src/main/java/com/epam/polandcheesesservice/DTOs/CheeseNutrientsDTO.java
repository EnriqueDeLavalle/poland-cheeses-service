package com.epam.polandcheesesservice.DTOs;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CheeseNutrientsDTO {

	private String id;
	private String productName;
	private int additivesN;
	private HashMap<?, ?> nutriments;

	public CheeseNutrientsDTO(@JsonProperty("id") String id, @JsonProperty("product_name") String productName,
			@JsonProperty("additives_n") int additivesN, @JsonProperty("nutriments") HashMap<?, ?> nutriments) {
		this.id = id;
		this.productName = productName;
		this.additivesN = additivesN;
		this.nutriments = nutriments;
	}

	public String getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public HashMap<?, ?> getNutriments() {
		return nutriments;
	}

	public int getAdditivesN() {
		return additivesN;
	}

}
