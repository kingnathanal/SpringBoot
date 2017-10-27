package com.engineering.vision;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.basePackage("com.engineering.vision"))
				.build()
				.apiInfo(metaInfo());
	}
	
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Rest Api for Vision Projecet",
				"Spring Boot Rest Api Service for Vins and Sales Codes",
				"1.1",
				"Terms of Service",
				new Contact("Detroit Diesel Engineering","http://visionrestapi.azurewebsites.net/","william.britton@daimler.com"),
				"Detroit Diesel","https://demanddetroit.com/"
		);
		return apiInfo;		
	}
}
