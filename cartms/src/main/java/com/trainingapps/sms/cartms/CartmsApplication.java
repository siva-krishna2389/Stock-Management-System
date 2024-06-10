package com.trainingapps.sms.cartms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.trainingapps.sms.cartms.ui.FrontEnd;

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
public class CartmsApplication {

	private static final Logger Log = LoggerFactory.getLogger(CartmsApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CartmsApplication.class, args);
		FrontEnd frontend = context.getBean(FrontEnd.class);
		frontend.start();
		Log.debug("i am logged with debug level");
		Log.info("i am logged with info level");
		Log.error("i am logged with error level");

	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.trainingapps.sms.cartms")).paths(PathSelectors.any())
				.build();
	}

	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Stcok management application").description("rest api for Cart  Module")
				.build();

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
