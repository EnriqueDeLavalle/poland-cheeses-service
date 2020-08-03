package com.epam.polandcheesesservice.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.epam.polandcheesesservice.DTOs.CheeseApiResponseDTO;
import com.epam.polandcheesesservice.DTOs.CheeseNutrientsDTO;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CheeseNutrimentsServiceTest {

	@InjectMocks
	CheeseNutrimentsServiceImpl cheeseNutrimentsService;

	@Mock
	RestTemplate restTemplate;

	@Test
	@DisplayName("ChessesNutriments Test with result")
	void getChessesNutrimentsCase() throws Exception {
		// given
		CheeseNutrientsDTO cheeseNutrients = new CheeseNutrientsDTO("5902476000391", "Twaróg chudy", 0,
				new HashMap<String, String>());
		CheeseApiResponseDTO product = new CheeseApiResponseDTO(1, "product found", cheeseNutrients);

		when(cheeseNutrimentsService.getCheeseNutrimentsFacts("5902476000391")).thenReturn(product);

		// when
		CheeseApiResponseDTO productsReturn = cheeseNutrimentsService.getCheeseNutrimentsFacts("5902476000391");
		CheeseNutrientsDTO cheese = productsReturn.getProduct();

		// then
		assertThat(cheese.getProductName()).isEqualTo(cheeseNutrients.getProductName());
		assertThat(cheese.getAdditivesN()).isEqualTo(cheeseNutrients.getAdditivesN());

	}

	// TODO ChessesNutriments Test with exception result for now coverage over 80 %

}
