package org.company.pipeline_architecture.services.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendOrder(String orderInfo) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, orderInfo);
    }



}
