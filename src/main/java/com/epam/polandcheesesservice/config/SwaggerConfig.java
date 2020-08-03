package com.epam.polandcheesesservice.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/polandCheeses/*"))
				.apis(RequestHandlerSelectors.basePackage("com.epam"))
				.build().apiInfo( apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Food Facts API Documentation", 
				"POC for Spring Knowledge",
				"1.0", 
				"Free to use", 
				new springfox.documentation.service.Contact("Enrique De Lavalle", "enrique_de_lavalle@epam.com", "enrique_de_lavalle@epam.com"),
				"API License", 
				"enrique_de_lavalle@epam.com",
				Collections.emptyList());
	}
	
	
	
}
