package com.alkoscode.amqp.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public record RabbitMQMessageProducer(AmqpTemplate amqpTemplate) {

    public void publish(final String exchange, final String routingKey, final Object payload) {
        log.info("Publishing to {} using routing key {}. Payload: {}", exchange, routingKey, payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("Published to {} using routing key {}. Payload: {}", exchange, routingKey, payload);
    }
}
