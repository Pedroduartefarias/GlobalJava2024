package br.com.fiap.globaljava.auth;

import br.com.fiap.globaljava.usuario.Usuario;
import br.com.fiap.globaljava.usuario.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {


    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public Token login(Credentials credentials){
        var user = usuarioRepository.findByEmail(credentials.email())
                .orElseThrow( () -> new RuntimeException("Access Denied") );

        if ( !passwordEncoder.matches(credentials.senha(), user.getSenha()) )
            throw new RuntimeException("Access Denied");

        return tokenService.createToken(credentials);

    }

}