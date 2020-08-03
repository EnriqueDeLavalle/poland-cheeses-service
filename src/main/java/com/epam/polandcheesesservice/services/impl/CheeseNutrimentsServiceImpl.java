package com.epam.polandcheesesservice.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.epam.polandcheesesservice.DTOs.CheeseApiResponseDTO;
import com.epam.polandcheesesservice.services.CheeseNutrimentsService;

@Service
public class CheeseNutrimentsServiceImpl implements CheeseNutrimentsService {
	
	
	Logger logger = LoggerFactory.getLogger(CheeseNutrimentsServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${productURL}")
	private String productURL;

	@Override
	public CheeseApiResponseDTO getCheeseNutrimentsFacts(String idProduct) {
		
		CheeseApiResponseDTO cheeseNutrimentsResponse = null;
		try {
			cheeseNutrimentsResponse = restTemplate.getForObject(productURL + idProduct, CheeseApiResponseDTO.class);
		} catch (RestClientException ex) {
			logger.error(ex.getMessage());
		}
		
		
		return cheeseNutrimentsResponse;
	}

}
