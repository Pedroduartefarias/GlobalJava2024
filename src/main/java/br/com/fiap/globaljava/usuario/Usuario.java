package br.com.fiap.globaljava.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import br.com.fiap.globaljava.historicoRecomendacao.HistoricoRecomendacao;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuarios_global_java")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private String role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<HistoricoRecomendacao> historicoRecomendacoes;
}
