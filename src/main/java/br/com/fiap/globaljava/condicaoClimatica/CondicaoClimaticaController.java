package br.com.fiap.globaljava.condicaoClimatica;

import br.com.fiap.globaljava.condicaoClimatica.dto.CondicaoClimaticaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/condicoes-climaticas")
@Tag(name = "Condições Climáticas", description = "Endpoints para buscar condições climáticas")
@RequiredArgsConstructor
public class CondicaoClimaticaController {
    private final CondicaoClimaticaService condicaoClimaticaService;



    @GetMapping("/{cidade}")
    @Operation(summary = "Buscar condição climática", description = "Busca as condições climáticas atuais para uma cidade específica.")
    public ResponseEntity<CondicaoClimatica> buscarCondicaoClimatica(@PathVariable String cidade) {
        CondicaoClimatica condicao = condicaoClimaticaService.buscarEArmazenarCondicao(cidade);
        return ResponseEntity.ok(condicao);
    }
}