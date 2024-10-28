package com.example.Gauss;

import com.example.Gauss.Config.RabbitMQConfig;
import com.example.Gauss.Factory.Component.ComponentProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Service
public class CustomScheduler {

    @Autowired
    private ComponentProducer componentProducer;

    public void scheduleTasks() {
        Flux.interval(Duration.ofSeconds(1))
                .publishOn(Schedulers.boundedElastic())
                .subscribe(i -> {
                    String queueName = (i % 2 == 0) ? RabbitMQConfig.COMPONENT_QUEUE : RabbitMQConfig.ASSEMBLY_QUEUE;
                    String componentName = "Component-" + i;
                    componentProducer.produceComponent(queueName, componentName);
                    System.out.println("Scheduled task " + i);
                });
    }
}
