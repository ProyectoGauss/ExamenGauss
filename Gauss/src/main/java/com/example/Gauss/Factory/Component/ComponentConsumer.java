package com.example.Gauss.Factory.Component;

import com.example.Gauss.Config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ComponentConsumer {

    @RabbitListener(queues = RabbitMQConfig.COMPONENT_QUEUE)
    public void consumeComponent(String componentName) {
        System.out.println("Consumed component: " + componentName);
        // Process the component
    }
}
