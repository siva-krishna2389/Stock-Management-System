package com.trainingapps.sms.reportms;

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

/*
*This is the main and configuration class also Scans the base package and sub packages of project
*Swagger is documentation of REST API so any client can consume the url and use our REST services 
*/
@EnableDiscoveryClient
@EnableSwagger2
@SpringBootApplication
public class SalesReportmsApplication {

	public static void main(String[] args) {
		 SpringApplication.run(SalesReportmsApplication.class, args);
	}

	/*
	 * Base package to scan and generate the documentation
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.trainingapps.sms.reportms")).paths(PathSelectors.any())
				.build();

	}

	/*
	 * Title and description to appear in the swagger documentation are provided
	 */
	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Stock Management Application")
				.description("Rest API for Sales Report Management").build();

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
