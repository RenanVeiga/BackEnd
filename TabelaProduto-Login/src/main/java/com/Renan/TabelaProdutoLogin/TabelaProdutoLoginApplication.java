package com.Renan.TabelaProdutoLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication()
@ComponentScan(basePackages= {"com.Renan.TabelaProdutoLogin.CRUD"})
public class TabelaProdutoLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(TabelaProdutoLoginApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsMvcConfigurer() {
		return new WebMvcConfigurer() {
			
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				.allowedMethods("GET", "POST", "PUT", "DELETE")
				.allowedHeaders("*")
				.allowedOrigins("http://localhost:4200");
			}
		};
	}
	
}
