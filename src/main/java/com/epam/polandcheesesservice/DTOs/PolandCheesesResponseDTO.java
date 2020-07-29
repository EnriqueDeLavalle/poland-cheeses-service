package com.epam.polandcheesesservice.DTOs;

import java.util.List;

import com.epam.polandcheesesservice.model.Cheese;

public class PolandCheesesResponseDTO {

	private int status;
	private String statusVerbose;
	private List<Cheese> products;

	public PolandCheesesResponseDTO() {
		super();
	}

	public PolandCheesesResponseDTO(int status, String statusVerbose, List<Cheese> products) {
		super();
		this.status = status;
		this.statusVerbose = statusVerbose;
		this.products = products;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusVerbose() {
		return statusVerbose;
	}

	public void setStatusVerbose(String statusVerbose) {
		this.statusVerbose = statusVerbose;
	}

	public List<Cheese> getProducts() {
		return products;
	}

	public void setProducts(List<Cheese> products) {
		this.products = products;
	}

}
