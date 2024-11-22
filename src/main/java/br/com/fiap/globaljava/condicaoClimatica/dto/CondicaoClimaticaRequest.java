package br.com.fiap.globaljava.condicaoClimatica.dto;

import br.com.fiap.globaljava.condicaoClimatica.CondicaoClimatica;

import java.math.BigDecimal;

public record CondicaoClimaticaRequest(Long id, String condicao, Double temperatura, Double umidade, Double irradiacaoSolar) {

    public CondicaoClimatica toModel() {
        return CondicaoClimatica.builder()
                .id(id)
                .condicao(condicao)
                .temperatura(temperatura)
                .umidade(umidade)
                .irradiacaoSolar(irradiacaoSolar)
                .build();
    }
}
