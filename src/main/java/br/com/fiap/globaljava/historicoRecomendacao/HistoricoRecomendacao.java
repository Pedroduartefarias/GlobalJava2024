package br.com.fiap.globaljava.historicoRecomendacao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import br.com.fiap.globaljava.usuario.Usuario;
import br.com.fiap.globaljava.condicaoClimatica.CondicaoClimatica;

import java.time.LocalDateTime;

@Entity
@Table(name = "historico_recomendacoes")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoRecomendacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    private String recomendacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "condicao_climatica_id")
    private CondicaoClimatica condicaoClimatica;
}
