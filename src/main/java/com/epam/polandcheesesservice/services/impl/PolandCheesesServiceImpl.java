package com.epam.polandcheesesservice.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.epam.polandcheesesservice.DTOs.PolandCheesesDTO;
import com.epam.polandcheesesservice.services.PolandCheesesService;

@Service
public class PolandCheesesServiceImpl implements PolandCheesesService {

	Logger logger = LoggerFactory.getLogger(PolandCheesesServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${cheesesURL}")
	private String cheesesURL;

	public PolandCheesesDTO getPolandChesses() {

		PolandCheesesDTO chessesResponse = null;
		try {
			chessesResponse = restTemplate.getForObject(cheesesURL, PolandCheesesDTO.class);
		} catch (RestClientException ex) {
			logger.error(ex.getMessage());
		}

		return chessesResponse;
	}

}
