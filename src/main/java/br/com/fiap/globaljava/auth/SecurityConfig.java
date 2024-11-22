package br.com.fiap.globaljava.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain config(HttpSecurity http, AuthorizationFilter authorizationFilter) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests(auth -> auth
                // Permitir acesso ao Swagger UI e documentação
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()

                // Permitir login
                .requestMatchers(HttpMethod.POST, "/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/usuario").permitAll()
                .requestMatchers(HttpMethod.GET, "/usuario").permitAll()

                // Permitir acessos nos controladores de condições climáticas, histórico de recomendações e mensageria
                .requestMatchers(HttpMethod.GET, "/api/condicoes-climaticas/{cidade}").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/recomendacoes/gerar").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/climate/send-event").permitAll()

                // Rotas de perfil de usuário
                .requestMatchers(HttpMethod.GET, "/usuario/profile").authenticated()

                // Restringir todas as outras rotas
                .anyRequest().authenticated()
        );

        // Adicionar o filtro personalizado antes do filtro padrão de autenticação
        http.addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
