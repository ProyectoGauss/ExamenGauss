package com.example.Gauss.Factory.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void produceComponent(String queueName, String componentName) {
        try {
            String json = objectMapper.writeValueAsString(new Component(componentName));
            rabbitTemplate.convertAndSend(queueName, json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Component {
        private String name;

        public Component(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

