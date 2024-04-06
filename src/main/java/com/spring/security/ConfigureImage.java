package com.spring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//la clase que he creado es de configuracion
//para que spring reconosca y lo implementa a esa interfas
@Configuration
public class ConfigureImage implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        // alias para acceder ala carpeta ("/DatosImg/**")
        registry.addResourceHandler("/DatosImg/**").addResourceLocations("file:/C:/ZClinica/DatosImg/");
    }
}
