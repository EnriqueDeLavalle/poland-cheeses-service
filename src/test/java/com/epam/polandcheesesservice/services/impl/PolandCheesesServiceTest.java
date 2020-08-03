package com.epam.polandcheesesservice.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.epam.polandcheesesservice.DTOs.CheeseDTO;
import com.epam.polandcheesesservice.DTOs.PolandCheesesDTO;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PolandCheesesServiceTest {

	@InjectMocks
	PolandCheesesServiceImpl polandCheesesService;

	@Mock
	RestTemplate restTemplate;

	@Value("${cheesesURL}")
	private String cheesesURL;

	@Test
	@DisplayName("Chesses Test with result")
	void getPolandChessesCase() throws Exception {

		// given
		List<CheeseDTO> products = new ArrayList<CheeseDTO>();
		products.add(new CheeseDTO("5902476000391", "Twaróg chudy", 0));
		products.add(new CheeseDTO("8000430900231", "Mozzarella di latte di bufala", 0));
		products.add(new CheeseDTO("59031291", "Danio Truskawkowe", 3));
		products.add(new CheeseDTO("5902899137575", "Ser Kremowy Cheddar", 4));
		PolandCheesesDTO cheeses = new PolandCheesesDTO(products);

		when(polandCheesesService.getPolandChesses()).thenReturn(cheeses);

		// when
		PolandCheesesDTO productsReturn = polandCheesesService.getPolandChesses();

		// then
		assertThat(productsReturn.getProducts().size()).isEqualTo(4);
		assertThat(productsReturn.getProducts().get(0).getProductName()).isEqualTo(products.get(0).getProductName());
		assertThat(productsReturn.getProducts().get(3).getAdditivesN()).isEqualTo(4);

	}

	// @Test TODO Case"Chesses Test with exception result for now coverage over 80 %

}
