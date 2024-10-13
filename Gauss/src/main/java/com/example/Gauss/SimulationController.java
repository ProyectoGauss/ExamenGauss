package com.example.Gauss;

import com.example.Gauss.Factory.FactorySimulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for handling simulation-related web requests.
 */
@Controller
public class SimulationController {

    @Autowired
    private FactorySimulation factorySimulation;

    /**
     * Handles the root URL and returns the index page.
     *
     * @return the name of the index template
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * Starts the factory simulation and returns the simulation page.
     *
     * @return the name of the simulation template
     */
    @GetMapping("/start-simulation")
    public String startSimulation() {
        factorySimulation.startSimulation();
        return "simulation";
    }

    /**
     * Returns the falling balls simulation page.
     *
     * @return the name of the falling balls template
     */
    @GetMapping("/falling-balls")
    public String fallingBalls() {
        return "falling-balls";
    }
}


