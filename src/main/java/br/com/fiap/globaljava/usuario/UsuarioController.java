package br.com.fiap.globaljava.usuario;

import br.com.fiap.globaljava.usuario.dto.UsuarioProfileResponse;
import br.com.fiap.globaljava.usuario.dto.UsuarioFormRequest;
import br.com.fiap.globaljava.usuario.dto.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;


    // Criar um novo usuário
    @PostMapping
    public ResponseEntity<UsuarioResponse> create(@RequestBody UsuarioFormRequest usuarioForm, UriComponentsBuilder uriBuilder) {
        var usuario = service.create(usuarioForm.toModel());
        var uri = uriBuilder
                .path("/usuario/{id}")
                .buildAndExpand(usuario.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(UsuarioResponse.from(usuario));
    }

    @GetMapping
    public List<Usuario> findAll(@RequestParam(required = false) String nome){
        if (nome != null) return service.findByName(nome);
        return service.findAll();
    }

    // Obter o perfil do usuário autenticado
    @GetMapping("/profile")
    public UsuarioProfileResponse getProfile() {
        var email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return service.getProfile(email);
    }

    // Atualizar um usuário por ID
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioProfileResponse> updateUsuario(
            @PathVariable Long id,
            @RequestBody UsuarioFormRequest formRequest) {
        var usuario = service.update(id, formRequest);
        return ResponseEntity.ok(new UsuarioProfileResponse(usuario));
    }

    // Deletar um usuário por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
