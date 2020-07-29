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

import com.epam.polandcheesesservice.DTOs.CheeseNutrimentsResponseDTO;
import com.epam.polandcheesesservice.DTOs.PolandCheesesResponseDTO;
import com.epam.polandcheesesservice.controllers.PolandCheesesController;
import com.epam.polandcheesesservice.model.Cheese;
import com.epam.polandcheesesservice.model.CheeseNutrients;
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
		List<Cheese> products = new ArrayList<Cheese>();
		products.add(new Cheese("5902476000391", "Twaróg chudy", 0));
		products.add(new Cheese("8000430900231", "Mozzarella di latte di bufala", 0));
		products.add(new Cheese("59031291", "Danio Truskawkowe", 3));
		products.add(new Cheese("5902899137575", "Ser Kremowy Cheddar", 4));
		PolandCheesesResponseDTO cheeses = new PolandCheesesResponseDTO(1, "product found", products);

		when(polandCheesesService.getPolandChesses()).thenReturn(cheeses);

		// when
		PolandCheesesResponseDTO response = polandCheesesController.getPolandChesses();

		// then
		assertThat(response.getStatus()).isEqualTo(1);
		assertThat(response.getProducts().size()).isEqualTo(4);
		assertThat(response.getProducts().get(0).getProductName()).isEqualTo(products.get(0).getProductName());
		assertThat(response.getProducts().get(3).getAdditivesN()).isEqualTo(4);
	}
	
	@Test
	@DisplayName("Chesses Test with no result")
	void getPolandNoChessesCase() throws Exception {
		// given
		PolandCheesesResponseDTO cheeses = new PolandCheesesResponseDTO(1, "products no found", null);

		when(polandCheesesService.getPolandChesses()).thenReturn(cheeses);

		// when
		PolandCheesesResponseDTO response = polandCheesesController.getPolandChesses();

		// then
		assertThat(response.getStatus()).isEqualTo(1);
		assertThat(response.getProducts()).isEqualTo(null);
		

	}
	
	
	@Test
	@DisplayName("Chesses Test with Error")
	void getPolandChessesErrorCase() throws Exception {
		// given
		when(polandCheesesService.getPolandChesses()).thenThrow(Exception.class);

		// when
		PolandCheesesResponseDTO response = polandCheesesController.getPolandChesses();

		// then
		assertThat(response.getStatus()).isEqualTo(-1);
		assertThat(response.getProducts()).isEqualTo(null);
	}
	
	
	@Test
	@DisplayName("ChessesNutriments Test with result")
	void getChessesNutrimentsCase() throws Exception {
		// given
		CheeseNutrients cheeseNutrients = new CheeseNutrients("5902476000391","Twaróg chudy", null );
		
		CheeseNutrimentsResponseDTO nutriments = new CheeseNutrimentsResponseDTO(1, "product found", cheeseNutrients);
		
		when(cheeseNutrimentsService.getCheeseNutrimentsFacts("5902476000391")).thenReturn(nutriments);

		// when
		CheeseNutrimentsResponseDTO response = cheeseNutrimentsService.getCheeseNutrimentsFacts("5902476000391");

		// then
		assertThat(response.getStatus()).isEqualTo(1);
		assertThat(response.getProduct().getProductName()).isEqualTo(cheeseNutrients.getProductName());

	}
	
	
	@Test
	@DisplayName("ChessesNutriments Test with no result")
	void getChessesNoNutrimentsCase() throws Exception {
		// given
		CheeseNutrimentsResponseDTO nutriments = new CheeseNutrimentsResponseDTO(0, "product no found", null);
		
		when(cheeseNutrimentsService.getCheeseNutrimentsFacts("123456789")).thenReturn(nutriments);

		// when
		CheeseNutrimentsResponseDTO response = cheeseNutrimentsService.getCheeseNutrimentsFacts("123456789");

		// then
		assertThat(response.getStatus()).isEqualTo(0);
		assertThat(response.getProduct()).isEqualTo(null);

	}
	
	@Test
	@DisplayName("ChessesNutriments Test with Error")
	void getChessesNutrimentsErrorCase() throws Exception {
		// given
		when(cheeseNutrimentsService.getCheeseNutrimentsFacts("123456789")).thenThrow(Exception.class);

		// when
		PolandCheesesResponseDTO response = polandCheesesController.getPolandChesses();

		// then
		assertThat(response.getStatus()).isEqualTo(-1);
		assertThat(response.getProducts()).isEqualTo(null);
	}
	
	
	


}
