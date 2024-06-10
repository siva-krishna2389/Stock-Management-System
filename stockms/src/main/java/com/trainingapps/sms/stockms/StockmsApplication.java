package com.trainingapps.sms.stockms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@EnableSwagger2

@SpringBootApplication
public class StockmsApplication {

	public static void main(String[] args) {

		SpringApplication.run(StockmsApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.trainingapps.sms.stockms")).paths(PathSelectors.any())
				.build();
		
	}

	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Stock Module").description("rest api for stock module").build();

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
