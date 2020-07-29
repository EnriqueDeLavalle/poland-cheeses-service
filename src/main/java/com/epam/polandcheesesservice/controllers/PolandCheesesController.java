package com.epam.polandcheesesservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.polandcheesesservice.DTOs.CheeseNutrimentsResponseDTO;
import com.epam.polandcheesesservice.DTOs.PolandCheesesResponseDTO;
import com.epam.polandcheesesservice.services.CheeseNutrimentsService;
import com.epam.polandcheesesservice.services.PolandCheesesService;

@RestController
@RequestMapping("/polandCheeses")
public class PolandCheesesController {

	@Autowired
	private PolandCheesesService polandCheesesService;

	@Autowired
	private CheeseNutrimentsService cheeseNutrimentsService;

	@RequestMapping("/cheeses")
	public PolandCheesesResponseDTO getPolandChesses() {
		try {
			PolandCheesesResponseDTO cheeses = polandCheesesService.getPolandChesses();
			cheeses.setStatus(1);
			cheeses.setStatusVerbose("product found");
			return cheeses;
		} catch (Exception e) {
			return new PolandCheesesResponseDTO(-1, "Error procesing the query", null);
		}
	}

	@RequestMapping("/nutriments/{productId}")
	public CheeseNutrimentsResponseDTO getCheeseNutrimentsFacts(@PathVariable("productId") String productId) {
		try {
			return cheeseNutrimentsService.getCheeseNutrimentsFacts(productId);
		} catch (Exception e) {
			return new CheeseNutrimentsResponseDTO(-1, "Error procesing the query", null);
		}
	}

}
