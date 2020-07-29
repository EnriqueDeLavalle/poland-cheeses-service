package com.epam.polandcheesesservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.epam.polandcheesesservice.DTOs.PolandCheesesResponseDTO;
import com.epam.polandcheesesservice.services.PolandCheesesService;

@Service
public class PolandCheesesServiceImpl implements PolandCheesesService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${cheesesURL}")
	private String cheesesURL;

	public PolandCheesesResponseDTO getPolandChesses() throws Exception {
		return restTemplate.getForObject(cheesesURL, PolandCheesesResponseDTO.class);
	}

}
