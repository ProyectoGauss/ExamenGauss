package com.example.Gauss;


import com.example.Gauss.Factory.Workstation.WorkstationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class SchedulingService {

    @Autowired
    private List<WorkstationService> workstations;

    public void scheduleProduction(List<String> components) {
        Flux.fromIterable(components)
            .index()
            .flatMap(indexedComponent -> {
                int workstationIndex = (int) (indexedComponent.getT1() % workstations.size());
                return workstations.get(workstationIndex).produceComponent(indexedComponent.getT2());
            })
            .subscribe();
    }
}
