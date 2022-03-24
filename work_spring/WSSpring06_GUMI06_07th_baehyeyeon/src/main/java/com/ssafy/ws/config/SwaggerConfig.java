package com.ssafy.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //SwaggerConfig class는 설정파일이고 얘를 빈으로 등록시킨다. 라는 뜻
@EnableSwagger2
public class SwaggerConfig {
	
	//Swagger에서는 docket이라는 객체가 필요하다.
	@Bean
	public Docket api() {
		
		final ApiInfo apiInfo = new ApiInfoBuilder()
				.title("SSAFY 도서관리 API")
				.description("<h3>워크샵에서 사용되는 RestApi에 대한 문서를 제공한다.</h3>")
				.contact(new Contact("SSAFY", "https://edu.ssafy.com", "ssafy@ssafy.com"))
				.license("MIT License")
				.version("1.0")
				.build();
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.ws.controller")) //REST API가 생성된 폴더
				.paths(PathSelectors.ant("/*/bookapi/**"))
				.build();
	}
}
