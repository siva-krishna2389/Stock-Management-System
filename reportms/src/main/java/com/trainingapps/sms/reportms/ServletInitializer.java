package com.trainingapps.sms.reportms;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/*
 * It lets spring boot application packages as war file to deploy on external tomcat and run  
 * the application without writing web.xml file
 * */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SalesReportmsApplication.class);
	}

}
