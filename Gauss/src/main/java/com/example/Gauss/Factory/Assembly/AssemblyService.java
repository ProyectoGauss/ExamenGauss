package com.example.Gauss.Factory.Assembly;

import com.example.Gauss.Controller.VisualizationController;
import com.example.Gauss.Rabbit.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AssemblyService {

    private static final Logger logger = LoggerFactory.getLogger(AssemblyService.class);

    @Autowired
    private VisualizationController visualizationController;

    @RabbitListener(queues = RabbitMQConfig.COMPONENT_QUEUE)
    public Mono<Void> assembleComponent(String component) {
        return Mono.fromRunnable(() -> {
            System.out.println("Assembled component: " + component);
            logger.info("Component assembly completed: " + component);
            visualizationController.sendUpdate("Component assembly completed: " + component);
        }).subscribeOn(Schedulers.boundedElastic()).then();
    }
}
