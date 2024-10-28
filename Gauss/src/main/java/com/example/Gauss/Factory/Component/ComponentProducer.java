package com.example.Gauss.Factory.Component;

import com.example.Gauss.Config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void produceComponent(String queueName, String componentName) {
        rabbitTemplate.convertAndSend(queueName, componentName);
    }
}

