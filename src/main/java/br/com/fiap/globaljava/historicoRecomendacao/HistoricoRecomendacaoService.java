package br.com.fiap.globaljava.historicoRecomendacao;

import br.com.fiap.globaljava.condicaoClimatica.CondicaoClimatica;
import br.com.fiap.globaljava.condicaoClimatica.CondicaoClimaticaService;
import br.com.fiap.globaljava.groq.GroqAIService;
import br.com.fiap.globaljava.usuario.Usuario;
import br.com.fiap.globaljava.mensageria.ClimateEventProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class HistoricoRecomendacaoService {

    private final HistoricoRecomendacaoRepository historicoRecomendacaoRepository;
    private final CondicaoClimaticaService condicaoClimaticaService;
    private final GroqAIService groqAIService;
    private final ClimateEventProducer climateEventProducer;  // Adicionando o producer para enviar eventos

    public HistoricoRecomendacao gerarRecomendacao(String cidade, Usuario usuario) {
        // Busca a condição climática e armazena
        CondicaoClimatica condicao = condicaoClimaticaService.buscarEArmazenarCondicao(cidade);

        // Gera o prompt para a IA
        String prompt = String.format("Baseado na condição climática atual: '%s' com %.1f°C, sugira uma recomendação personalizada de economia de energia solar.",
                condicao.getCondicao(), condicao.getTemperatura());

        // Obtém a resposta da IA
        String recomendacao = groqAIService.gerarResposta(prompt);

        // Cria e salva o histórico de recomendação
        HistoricoRecomendacao historico = HistoricoRecomendacao.builder()
                .dataHora(LocalDateTime.now())
                .recomendacao(recomendacao)
                .usuario(usuario)
                .condicaoClimatica(condicao)
                .build();

        historicoRecomendacaoRepository.save(historico);

        // Envia o evento para RabbitMQ
        climateEventProducer.sendClimateEvent("Nova recomendação gerada: " + recomendacao);

        return historico;
    }
}
