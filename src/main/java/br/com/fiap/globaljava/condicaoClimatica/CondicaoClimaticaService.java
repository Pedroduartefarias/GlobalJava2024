package br.com.fiap.globaljava.condicaoClimatica;

import br.com.fiap.globaljava.condicaoClimatica.dto.CondicaoClimaticaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CondicaoClimaticaService {

    private final CondicaoClimaticaRepository condicaoClimaticaRepository;
    private final RestTemplate restTemplate;

    @Value("${openweathermap.api-key}")
    private String apiKey;

    public CondicaoClimatica buscarEArmazenarCondicao(String cidade) {
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric", cidade, apiKey);

        ResponseEntity<CondicaoClimaticaApiResponse> response = restTemplate.getForEntity(url, CondicaoClimaticaApiResponse.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            CondicaoClimaticaApiResponse apiResponse = response.getBody();

            // Acessando as propriedades
            CondicaoClimatica condicao = CondicaoClimatica.builder()
                    .dataHora(LocalDateTime.now())
                    .condicao(apiResponse.getWeather().get(0).getDescription())
                    .temperatura(apiResponse.getMain().getTemp())
                    .umidade(apiResponse.getMain().getHumidity().doubleValue())
                    .irradiacaoSolar(apiResponse.getMain().getTemp() * 0.1)
                    .build();

            return condicaoClimaticaRepository.save(condicao);
        } else {
            throw new RuntimeException("Erro ao buscar dados da API do OpenWeatherMap");
        }
    }
}
