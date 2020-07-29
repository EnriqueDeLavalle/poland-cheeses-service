package com.epam.polandcheesesservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cheese {

	private String id;
	private String productName;
	private int additivesN;

	public Cheese() {
		super();
	}

	public Cheese(@JsonProperty("id") String id, @JsonProperty("product_name") String productName,
			@JsonProperty("additives_n") int additivesN) {
		super();
		this.id = id;
		this.productName = productName;
		this.additivesN = additivesN;
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

	public int getAdditivesN() {
		return additivesN;
	}

	public void setAdditivesN(int additivesN) {
		this.additivesN = additivesN;
	}

}
