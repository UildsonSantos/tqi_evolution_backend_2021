package com.tqi.uildsonsantos.creditmanager.config;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	private static final String BASE_PACKAGE = "com.tqi.uildsonsantos.creditmanager";
	private static final String API_TITLE = "Credit Analysis Management - Red pill to TQI Evolution valuation";
	private static final String API_DESCRIPTION = "REST API for Credit analysis";
	private static final String API_VERSION = "1.0.0";
	private static final String CONTACT_NAME = "Uildson S. dos Santos";
	private static final String CONTACT_GITHUB = "https://github.com/UildsonSantos/tqi_evolution_backend_2021";
	private static final String CONTACT_EMAIL = "wilder_shon@hotmail.com";

	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(basePackage(BASE_PACKAGE))
	                .paths(PathSelectors.any())
	                .build()
	                .apiInfo(buildApiInfo());
	    }

	    private ApiInfo buildApiInfo() {
	        return new ApiInfoBuilder()
	                .title(API_TITLE)
	                .description(API_DESCRIPTION)
	                .version(API_VERSION)
	                .contact(new Contact(CONTACT_NAME, CONTACT_GITHUB, CONTACT_EMAIL))
	                .build();
	    }
}
