package br.com.fiap.globaljava.usuario.dto;

import br.com.fiap.globaljava.usuario.Usuario;

public record UsuarioProfileResponse(
        Long id,
        String nome,
        String email,
        String role
) {
    public UsuarioProfileResponse(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getRole());
    }
}
