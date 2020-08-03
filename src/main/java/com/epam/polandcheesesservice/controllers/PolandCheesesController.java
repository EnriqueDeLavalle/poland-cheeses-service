package com.epam.polandcheesesservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.polandcheesesservice.DTOs.CheeseApiResponseDTO;
import com.epam.polandcheesesservice.DTOs.CheeseNutrientsDTO;
import com.epam.polandcheesesservice.DTOs.PolandCheesesDTO;
import com.epam.polandcheesesservice.services.CheeseNutrimentsService;
import com.epam.polandcheesesservice.services.PolandCheesesService;

@RestController
@RequestMapping("/polandCheeses")
public class PolandCheesesController {

	@Autowired
	private PolandCheesesService polandCheesesService;

	@Autowired
	private CheeseNutrimentsService cheeseNutrimentsService;

	@GetMapping("/")
	public ResponseEntity<PolandCheesesDTO> getPolandChesses() {

		PolandCheesesDTO cheeses = polandCheesesService.getPolandChesses();

		if (cheeses != null && cheeses.getProducts().size() > 0) {
			return new ResponseEntity<PolandCheesesDTO>(cheeses, HttpStatus.OK);
		} else {
			return new ResponseEntity<PolandCheesesDTO>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/{productId}")
	public ResponseEntity<CheeseNutrientsDTO> getCheeseNutrimentsFacts(
			@PathVariable("productId") String productId) {

		CheeseApiResponseDTO nutriments = cheeseNutrimentsService.getCheeseNutrimentsFacts(productId);

		if (nutriments != null && nutriments.getStatus() == 1) {
			return new ResponseEntity<CheeseNutrientsDTO>(nutriments.getProduct(), HttpStatus.OK);
		} else {
			return new ResponseEntity<CheeseNutrientsDTO>(HttpStatus.NOT_FOUND);
		}

	}
}
