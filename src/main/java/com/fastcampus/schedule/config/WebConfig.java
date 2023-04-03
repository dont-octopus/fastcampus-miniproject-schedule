package com.fastcampus.schedule.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	public static final String ALLOWED_METHOD_NAMES = "GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH";

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedMethods(ALLOWED_METHOD_NAMES.split(","))
				.allowedOrigins("*")
				.allowedHeaders("Access-Control-Allow-Origin")
				.allowedOrigins("http://13.124.96.231")
				.allowedOrigins("https://hue-manager.com")
				.allowedOrigins("http://localhost:3000")
				.allowedOrigins("http://localhost:5173")
				.allowedOrigins("https://hue-manager-project.netlify.app/")
				.allowCredentials(true)
				.allowedHeaders("*");
	}
}