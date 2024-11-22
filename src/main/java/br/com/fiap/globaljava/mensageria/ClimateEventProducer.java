package br.com.fiap.globaljava.mensageria;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ClimateEventProducer {

    private final RabbitTemplate rabbitTemplate;
    private final String exchange;
    private final String routingKey;

    public ClimateEventProducer(RabbitTemplate rabbitTemplate,
                                @Value("${app.rabbitmq.exchange}") String exchange,
                                @Value("${app.rabbitmq.routing-key}") String routingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    public void sendClimateEvent(String message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}