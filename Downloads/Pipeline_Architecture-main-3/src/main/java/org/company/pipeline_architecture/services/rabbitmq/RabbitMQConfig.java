package org.company.pipeline_architecture.services.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.context.support.GenericWebApplicationContext;


public class RabbitMQConfig {
    public static final String QUEUE_NAME = "orderQueue";
    public static final String EXCHANGE_NAME = "orderExchange";
    public static final String ROUTING_KEY = "orderRoutingKey";

    private GenericWebApplicationContext context;

    @Value("${spring.rabbitmq.host}")
    private String rabitHost;

    @Value("${spring.rabbitmq.port}")
    private int rabitPort;

    @Value("${spring.rabbitmq.username}")
    private String rabitUsername;

    @Value("${spring.rabbitmq.password}")
    private String rabitPassword;

    @Value("${spring.rabbitmq.virtual-host}")
    private String rabitVirtualHost;

    @Value("${spring.rabbitmq.virtual-host-job}")
    private String rabitVirtualHostJob;

    @Bean
    public Queue queue() {
        return new Queue("Pipeline_Architecture", true); // durable=true để tránh bị mất queue khi restart
    }


    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }


    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }



}