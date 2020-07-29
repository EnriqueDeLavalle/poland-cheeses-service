package com.epam.polandcheesesservice.DTOs;

import com.epam.polandcheesesservice.model.CheeseNutrients;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CheeseNutrimentsResponseDTO {

	private int status;
	private String statusVerbose;
	private CheeseNutrients product;

	public CheeseNutrimentsResponseDTO() {
		super();
	}

	public CheeseNutrimentsResponseDTO(@JsonProperty("status") int status,
			@JsonProperty("status_verbose") String statusVerbose, @JsonProperty("product") CheeseNutrients product) {
		super();
		this.status = status;
		this.statusVerbose = statusVerbose;
		this.product = product;
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

	public CheeseNutrients getProduct() {
		return product;
	}

	public void setProduct(CheeseNutrients product) {
		this.product = product;
	}

}
