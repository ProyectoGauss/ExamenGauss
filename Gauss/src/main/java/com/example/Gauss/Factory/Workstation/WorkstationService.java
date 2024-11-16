package com.example.Gauss.Factory.Workstation;

import com.example.Gauss.Factory.Component.ComponentProducer;
import com.example.Gauss.Rabbit.RabbitMQConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class WorkstationService {

    @Autowired
    private ComponentProducer componentProducer;

    private final List<String> workstations = List.of("Workstation1", "Workstation2", "Workstation3");

    public Flux<String> getWorkStations() {
        return Flux.fromIterable(workstations);
    }

    public Mono<Void> produceComponent(String componentName) {
        return Mono.fromRunnable(() -> componentProducer.produceComponent(RabbitMQConfig.COMPONENT_QUEUE, componentName));
    }
}
