package com.example.Gauss;

import com.example.Gauss.Factory.FactorySimulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimulationController {

    @Autowired
    private FactorySimulation factorySimulation;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/start-simulation")
    public String startSimulation() {
        factorySimulation.startSimulation();
        return "simulation";
    }

    @GetMapping("/falling-balls")
    public String fallingBalls() {
            return "falling-balls";
    }

}


