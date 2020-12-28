package com.cg.oas.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig 
{
	@Bean
	public Docket advertiseModule()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cg.oas"))
				.paths(PathSelectors.regex("/cgoas.*"))
				.build()
				.apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo()
	{
		ApiInfo apiInfo = new ApiInfo("Online Advertisement System API Documentation", 
				"This is Online Advertisement System", 
				"1.0", 
				"public terms of service", 
				new Contact("OAS Team","http://capgemini.com","oasteam@capgemini.com"), 
				null, 
				null);
		return apiInfo;
	}
}