package br.com.fiap.globaljava.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Monitoramento Climático para Energia Solar")
                        .description("Esta API permite monitorar condições climáticas e gerar recomendações de uso de energia solar com base no clima. Através de integrações com a API OpenWeatherMap e RabbitMQ, o sistema fornece dados sobre o clima e facilita a comunicação assíncrona entre os componentes do sistema, incluindo notificações e recomendações personalizadas.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Pedro Duarte Farias")
                                .email("pedrocomercial198@gmail.com")
                                .url("https://github.com/pedroduartefarias"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org"))
                )
                .servers(List.of(
                        new Server().url("http://localhost:8082").description("Servidor Local para Desenvolvimento")
                ));
    }
}