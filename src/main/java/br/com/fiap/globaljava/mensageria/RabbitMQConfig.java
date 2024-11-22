package br.com.fiap.globaljava.mensageria;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "climateQueue";

    @Bean
    public Queue climateQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public TopicExchange climateExchange() {
        return new TopicExchange("climateExchange");
    }

    @Bean
    public Binding binding(Queue climateQueue, TopicExchange climateExchange) {
        return BindingBuilder.bind(climateQueue).to(climateExchange).with("climate.routingkey");
    }
}
