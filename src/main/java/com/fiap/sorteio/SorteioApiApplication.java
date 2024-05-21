package com.fiap.sorteio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@Controller
@EnableCaching
@OpenAPIDefinition(
	info = @Info(
		title = "Sorteio API",
		version = "1.0.0",
		description = "API do app de controle de despesas pessoais",
		contact = @Contact(name = "Cássio Sakai", email = "rm551491@fiap.com.br")
	)
)
public class SorteioApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SorteioApiApplication.class, args);
    }
}
