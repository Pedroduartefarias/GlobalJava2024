package br.com.fiap.globaljava.groq;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class IAService {

    private final RestTemplate restTemplate;
    private final String apiKey = "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";
    private final String baseUrl = "https://api.groq.com/openai";

    public IAService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String gerarRecomendacao(String prompt) {
        String url = baseUrl + "/v1/chat/completions";

        IARequest request = new IARequest(
                "llama3-70b-8192",
                0.7,
                List.of(new IARequest.Message("user", prompt))
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        HttpEntity<IARequest> entity = new HttpEntity<>(request, headers);

        IAResponse response = restTemplate.postForObject(url, entity, IAResponse.class);

        if (response != null && response.getChoices() != null && !response.getChoices().isEmpty()) {
            return response.getChoices().get(0).getMessage().getContent();
        }

        throw new RuntimeException("Falha ao gerar recomendação da IA");
    }
}
