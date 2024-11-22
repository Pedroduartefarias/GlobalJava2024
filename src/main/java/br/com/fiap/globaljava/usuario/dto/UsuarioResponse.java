package br.com.fiap.globaljava.usuario.dto;

import br.com.fiap.globaljava.usuario.Usuario;
import lombok.Data;

import java.time.LocalDateTime;
public record UsuarioResponse(
        Long id,
        String nome,
        String email,
        LocalDateTime createdAt
) {
    public static UsuarioResponse from(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getCreatedAt()
        );
    }
}