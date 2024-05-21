package com.fiap.sorteio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Sorteio", description = "Endpoints para sorteio de números")
public class SorteioController {

    private final Random random = new Random();

    @GetMapping("/dado")
    @Operation(summary = "Sorteio de dado de 6 lados", description = "Retorna um número aleatório entre 1 e 6")
    public int rolarDado() {
        return random.nextInt(6) + 1;
    }

    @GetMapping("/dado/{maximo}")
    @Operation(summary = "Sorteio de dado personalizado", description = "Retorna um número aleatório entre 1 e o número máximo especificado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Número sorteado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Valor máximo inválido")
    })
    public int rolarDadoComMaximo(@PathVariable int maximo) {
        if (maximo < 1) {
            throw new IllegalArgumentException("O valor máximo deve ser maior que zero");
        }
        return random.nextInt(maximo) + 1;
    }
}
