package br.com.fiap.globaljava.condicaoClimatica;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "condicoes_climaticas")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CondicaoClimatica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dataHora")
    private LocalDateTime dataHora;

    @Column(name = "condicao", nullable = false, length = 50)
    private String condicao;

    @Column(name = "temperatura", nullable = false)
    private Double temperatura;

    @Column(name = "umidade", nullable = false)
    private Double umidade;

    @Column(name = "irradiacaoSolar", nullable = false)
    private Double irradiacaoSolar;
}
