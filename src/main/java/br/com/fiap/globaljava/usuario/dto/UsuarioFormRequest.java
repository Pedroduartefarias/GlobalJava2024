package br.com.fiap.globaljava.usuario.dto;


import br.com.fiap.globaljava.usuario.Usuario;

import java.time.LocalDateTime;

public record UsuarioFormRequest(
        String nome,
        String email,
        String senha,
        String role
) {
    public Usuario toModel() {
        return Usuario.builder()
                .nome(nome)
                .email(email)
                .senha(senha)
                .role(role)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}