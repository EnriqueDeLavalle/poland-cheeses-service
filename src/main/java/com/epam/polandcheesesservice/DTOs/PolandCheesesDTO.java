package com.epam.polandcheesesservice.DTOs;

import java.util.List;

public class PolandCheesesDTO {

	private List<CheeseDTO> products;

	public PolandCheesesDTO() {
	}

	public PolandCheesesDTO(List<CheeseDTO> products) {
		this.products = products;
	}

	public List<CheeseDTO> getProducts() {
		return products;
	}

	public void setProducts(List<CheeseDTO> products) {
		this.products = products;
	}

}
