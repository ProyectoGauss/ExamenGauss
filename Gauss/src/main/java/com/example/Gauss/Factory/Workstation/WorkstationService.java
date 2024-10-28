// WorkStationService.java
package com.example.Gauss.Factory.Workstation;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import java.time.Duration;

@Service
public class WorkstationService {

    public Flux<String> getWorkStations() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> "WorkStation " + sequence)
                .take(10); // Simula 10 estaciones de trabajo
    }
}
