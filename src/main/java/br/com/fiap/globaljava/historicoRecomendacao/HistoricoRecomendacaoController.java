package br.com.fiap.globaljava.historicoRecomendacao;

import br.com.fiap.globaljava.usuario.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recomendacoes")
@Tag(name = "Recomendações", description = "Endpoints para geração de recomendações baseadas em histórico")
@RequiredArgsConstructor
public class HistoricoRecomendacaoController {

    private final HistoricoRecomendacaoService historicoRecomendacaoService;

    @PostMapping("/gerar")
    @Operation(summary = "Gerar recomendação", description = "Gera uma recomendação personalizada com base na cidade e no histórico do usuário.")
    public ResponseEntity<HistoricoRecomendacao> gerarRecomendacao(@RequestBody Usuario usuario, @RequestParam String cidade) {
        return ResponseEntity.ok(historicoRecomendacaoService.gerarRecomendacao(cidade, usuario));
    }
}
