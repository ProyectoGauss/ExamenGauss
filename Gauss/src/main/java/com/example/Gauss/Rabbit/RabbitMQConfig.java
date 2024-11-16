package com.example.Gauss.Rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String COMPONENT_QUEUE = "componentQueue";
    public static final String ASSEMBLY_QUEUE = "assemblyQueue";

    @Bean
    public Queue componentQueue() {
        return new Queue(COMPONENT_QUEUE);
    }

    @Bean
    public Queue assemblyQueue() {
        return new Queue(ASSEMBLY_QUEUE);
    }
}
