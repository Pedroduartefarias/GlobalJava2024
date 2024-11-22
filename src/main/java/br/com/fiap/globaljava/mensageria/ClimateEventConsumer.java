package br.com.fiap.globaljava.mensageria;

import br.com.fiap.globaljava.historicoRecomendacao.HistoricoRecomendacaoService;
import br.com.fiap.globaljava.usuario.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Service
public class ClimateEventConsumer {

    private final HistoricoRecomendacaoService historicoRecomendacaoService;

    public ClimateEventConsumer(HistoricoRecomendacaoService historicoRecomendacaoService) {
        this.historicoRecomendacaoService = historicoRecomendacaoService;
    }

    @RabbitListener(queues = "climateQueue")
    public void receiveMessage(String message) {
        System.out.println("Mensagem recebida: " + message);

        // Exemplo de lógica para gerar recomendação após receber uma mensagem
        // Aqui você pode adicionar a lógica para tomar ações dependendo da mensagem recebida
        String cidade = "São Paulo"; // Ajuste conforme necessário
        // Criar um usuário fictício ou pegar o usuário real
        // Aqui estamos assumindo que o usuário é passado de alguma maneira
        Usuario usuario = new Usuario();  // Ajuste conforme necessário
        historicoRecomendacaoService.gerarRecomendacao(cidade, usuario);
    }
}
