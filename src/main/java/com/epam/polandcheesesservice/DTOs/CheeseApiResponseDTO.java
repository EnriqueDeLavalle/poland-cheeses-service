package com.epam.polandcheesesservice.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CheeseApiResponseDTO {

	private int status;
	private String statusVerbose;
	private CheeseNutrientsDTO product;

	public CheeseApiResponseDTO(@JsonProperty("status") int status,
			@JsonProperty("status_verbose") String statusVerbose, @JsonProperty("product") CheeseNutrientsDTO product) {
		this.status = status;
		this.statusVerbose = statusVerbose;
		this.product = product;
	}

	public int getStatus() {
		return status;
	}

	public String getStatusVerbose() {
		return statusVerbose;
	}

	public CheeseNutrientsDTO getProduct() {
		return product;
	}

}
