package com.example.Gauss;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Rest controller for simulating the falling balls and providing real-time data.
 */
@RestController
public class SimulationRestController {

    private final AtomicInteger[] bins = new AtomicInteger[5];

    /**
     * Initializes the bins with zero counts.
     */
    public SimulationRestController() {
        for (int i = 0; i < bins.length; i++) {
            bins[i] = new AtomicInteger(0);
        }
    }

    /**
     * Provides the current state of the bins.
     *
     * @return an array of integers representing the number of balls in each bin.
     */
    @GetMapping("/api/falling-balls-data")
    public int[] getFallingBallsData() {
        int[] data = new int[bins.length];
        for (int i = 0; i < bins.length; i++) {
            data[i] = bins[i].get();
        }
        return data;
    }

    /**
     * Simulates a ball falling into a random bin every second.
     */
    @Scheduled(fixedRate = 1000)
    public void simulateBallFalling() {
        int binIndex = (int) (Math.random() * bins.length);
        bins[binIndex].incrementAndGet();
    }
}
