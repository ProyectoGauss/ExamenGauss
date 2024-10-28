// WorkStationController.java
package com.example.Gauss.Factory.Workstation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class WorkstationController {

    @Autowired
    private WorkstationService workStationService;

    @GetMapping("/workstations")
    public Flux<String> getWorkStations() {
        return workStationService.getWorkStations();
    }
}
