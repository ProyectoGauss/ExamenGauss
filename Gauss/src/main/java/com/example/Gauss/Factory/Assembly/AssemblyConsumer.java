package com.example.Gauss.Factory.Assembly;

import com.example.Gauss.Rabbit.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class AssemblyConsumer {

    @RabbitListener(queues = RabbitMQConfig.ASSEMBLY_QUEUE)
    public void consumeAssembly(String componentName) {
        System.out.println("Assembled component: " + componentName);
        // Process the assembly
    }
}
