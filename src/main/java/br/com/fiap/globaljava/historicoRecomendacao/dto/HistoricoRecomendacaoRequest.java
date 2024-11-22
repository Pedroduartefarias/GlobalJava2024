package br.com.fiap.globaljava.historicoRecomendacao.dto;

import br.com.fiap.globaljava.historicoRecomendacao.HistoricoRecomendacao;
import br.com.fiap.globaljava.usuario.Usuario;
import br.com.fiap.globaljava.condicaoClimatica.CondicaoClimatica;

import java.time.LocalDateTime;

public record HistoricoRecomendacaoRequest(Long id, String recomendacao, LocalDateTime dataHora, Usuario usuario, CondicaoClimatica condicaoClimatica) {

    public HistoricoRecomendacao toModel() {
        return HistoricoRecomendacao.builder()
                .id(id)
                .recomendacao(recomendacao)
                .dataHora(dataHora != null ? dataHora : LocalDateTime.now())  // Se dataHora não for passado, usa a data atual
                .usuario(usuario)
                .condicaoClimatica(condicaoClimatica)
                .build();
    }
}