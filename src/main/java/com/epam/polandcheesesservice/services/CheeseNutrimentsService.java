package com.epam.polandcheesesservice.services;

import com.epam.polandcheesesservice.DTOs.CheeseNutrimentsResponseDTO;

public interface CheeseNutrimentsService {

	CheeseNutrimentsResponseDTO getCheeseNutrimentsFacts(String idProduct) throws Exception;

}
