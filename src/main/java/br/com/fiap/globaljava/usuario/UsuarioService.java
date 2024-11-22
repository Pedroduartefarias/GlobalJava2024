package br.com.fiap.globaljava.usuario;

import br.com.fiap.globaljava.usuario.dto.UsuarioFormRequest;
import br.com.fiap.globaljava.usuario.dto.UsuarioProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    // Buscar todos os usuários
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    // Criar um novo usuário
    public Usuario create(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha())); // Criptografa a senha
        usuario.setCreatedAt(LocalDateTime.now()); // Define o campo createdAt
        usuario.setUpdatedAt(LocalDateTime.now()); // Define o campo updatedAt
        return repository.save(usuario);
    }

    // Buscar perfil pelo email
    public UsuarioProfileResponse getProfile(String email) {
        return repository.findByEmail(email)
                .map(UsuarioProfileResponse::new)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

    // Buscar usuários por nome
    public List<Usuario> findByName(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    // Atualizar um usuário
    public Usuario update(Long id, UsuarioFormRequest formRequest) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        usuario.setNome(formRequest.nome());
        usuario.setEmail(formRequest.email());
        if (formRequest.senha() != null && !formRequest.senha().isBlank()) {
            usuario.setSenha(passwordEncoder.encode(formRequest.senha())); // Atualiza senha apenas se fornecida
        }
        usuario.setUpdatedAt(LocalDateTime.now());
        return repository.save(usuario);
    }

    // Buscar um usuário por ID
    public Usuario findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

    // Deletar um usuário
    public void delete(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        repository.delete(usuario);
    }
}
