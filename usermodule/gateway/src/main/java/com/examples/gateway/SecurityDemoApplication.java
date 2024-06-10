package com.examples.gateway;

import com.examples.gateway.userms.entities.Admin;
import com.examples.gateway.userms.entities.User;
import com.examples.gateway.userms.service.IAdminService;
import com.examples.gateway.userms.service.IUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

@EnableSwagger2
@EnableDiscoveryClient
@EnableZuulProxy
@EnableCircuitBreaker
@EnableTransactionManagement
@SpringBootApplication
public class SecurityDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SecurityDemoApplication.class, args);
        IAdminService adminService = context.getBean(IAdminService.class);
        IUserService userService = context.getBean(IUserService.class);
        Set<String> roles=new HashSet<>();
        roles.add("admin");
        User user=userService.add("raju","raju",roles);
        Admin admin = new Admin();
        admin.setUser(user);
        adminService.add(admin);
    }

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(  apiInfo() )
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cg.securitydemo"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("user module demo")
                .description("rest api")
                .build();
    }
}
