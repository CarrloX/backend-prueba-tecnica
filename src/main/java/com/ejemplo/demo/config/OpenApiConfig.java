package com.ejemplo.demo.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "API REST prueba tecnica", version = "1.0", description = "Documentación de la API REST para prueba técnica"))
public class OpenApiConfig {

}
