package com.example.Gauss;

import com.example.Gauss.Config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SharedMemoryService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void writeToSharedMemory(String data) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.COMPONENT_QUEUE, data);
    }

    @RabbitListener(queues = RabbitMQConfig.COMPONENT_QUEUE)
    public void readFromSharedMemory(String data) {
        System.out.println("Read from shared memory: " + data);
        // Process the data
    }
}
