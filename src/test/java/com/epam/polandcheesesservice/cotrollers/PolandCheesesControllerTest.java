package com.epam.polandcheesesservice.cotrollers;

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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.epam.polandcheesesservice.DTOs.CheeseApiResponseDTO;
import com.epam.polandcheesesservice.DTOs.CheeseDTO;
import com.epam.polandcheesesservice.DTOs.CheeseNutrientsDTO;
import com.epam.polandcheesesservice.DTOs.PolandCheesesDTO;
import com.epam.polandcheesesservice.controllers.PolandCheesesController;
import com.epam.polandcheesesservice.services.CheeseNutrimentsService;
import com.epam.polandcheesesservice.services.PolandCheesesService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PolandCheesesControllerTest {

	@InjectMocks
	PolandCheesesController polandCheesesController;

	@Mock
	PolandCheesesService polandCheesesService;

	@Mock
	CheeseNutrimentsService cheeseNutrimentsService;

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
		ResponseEntity<PolandCheesesDTO> response = polandCheesesController.getPolandChesses();
		PolandCheesesDTO productsReturn = response.getBody();
		// then
		assertThat(response.getStatusCode().compareTo(HttpStatus.OK) == 1);
		assertThat(productsReturn.getProducts().size()).isEqualTo(4);
		assertThat(productsReturn.getProducts().get(0).getProductName()).isEqualTo(products.get(0).getProductName());
		assertThat(productsReturn.getProducts().get(3).getAdditivesN()).isEqualTo(4);
	}

	@Test
	@DisplayName("Chesses Test with no result")
	void getPolandNoChessesCase() throws Exception {

		// given
		when(polandCheesesService.getPolandChesses()).thenReturn(null);

		// when
		ResponseEntity<PolandCheesesDTO> response = polandCheesesController.getPolandChesses();
		// then
		assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND) == 1);

	}

	@Test
	@DisplayName("ChessesNutriments Test with result")
	void getChessesNutrimentsCase() throws Exception {
		// given
		CheeseNutrientsDTO cheeseNutrients = new CheeseNutrientsDTO("5902476000391", "Twaróg chudy", 0, null);
		CheeseApiResponseDTO product = new CheeseApiResponseDTO(1, "product found", cheeseNutrients);

		when(cheeseNutrimentsService.getCheeseNutrimentsFacts("5902476000391")).thenReturn(product);

		// when
		ResponseEntity<CheeseNutrientsDTO> response = polandCheesesController.getCheeseNutrimentsFacts("5902476000391");
		CheeseNutrientsDTO productsReturn = response.getBody();

		// then
		assertThat(response.getStatusCode().compareTo(HttpStatus.OK) == 1);
		assertThat(productsReturn.getProductName()).isEqualTo(cheeseNutrients.getProductName());

	}

	@Test
	@DisplayName("ChessesNutriments Test with no result")
	void getChessesNoNutrimentsCase() throws Exception {

		// given
		CheeseApiResponseDTO product = new CheeseApiResponseDTO(0, "product no found", null);

		when(cheeseNutrimentsService.getCheeseNutrimentsFacts("5902476000391")).thenReturn(product);

		// when
		ResponseEntity<CheeseNutrientsDTO> response = polandCheesesController.getCheeseNutrimentsFacts("5902476000391");
		
		// then
		assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND) == 1);

	}

}
