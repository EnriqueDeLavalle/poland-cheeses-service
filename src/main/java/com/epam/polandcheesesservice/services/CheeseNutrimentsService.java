package com.epam.polandcheesesservice.services;

import com.epam.polandcheesesservice.DTOs.CheeseApiResponseDTO;

public interface CheeseNutrimentsService {

	CheeseApiResponseDTO getCheeseNutrimentsFacts(String idProduct);

}
