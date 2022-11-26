package com.example.events.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @since
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedMethods("*")
        .allowedOrigins("http://localhost:4200/")
        .allowedHeaders("*")
        .allowCredentials(false)
        .maxAge(-1);
  }
}