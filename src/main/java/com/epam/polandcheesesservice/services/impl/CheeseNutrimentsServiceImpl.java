package com.epam.polandcheesesservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.epam.polandcheesesservice.DTOs.CheeseNutrimentsResponseDTO;
import com.epam.polandcheesesservice.services.CheeseNutrimentsService;

@Service
public class CheeseNutrimentsServiceImpl implements CheeseNutrimentsService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${productURL}")
	private String productURL;

	@Override
	public CheeseNutrimentsResponseDTO getCheeseNutrimentsFacts(String idProduct) throws Exception{
		return restTemplate.getForObject(productURL + idProduct, CheeseNutrimentsResponseDTO.class);
	}

}
