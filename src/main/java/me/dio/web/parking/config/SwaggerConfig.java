package me.dio.web.parking.config;


import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
public class SwaggerConfig {
	
	@Bean
	GroupedOpenApi publicApi() {
	      return GroupedOpenApi.builder()
	              .group("web.dio.me")	              
	              .pathsToMatch("/parking/**")	              
	              .build();	             
	  }
	
	@Bean
	OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("Parking API")	            		  
	              .description("Parking API Application")
	              .version("v0.0.1")
	              .license(new License().name("Apache 2.0").url("http://springdoc.org")))
	              .externalDocs(new ExternalDocumentation()
	              .description("Parking API Documentation"));	              
	  }	
}