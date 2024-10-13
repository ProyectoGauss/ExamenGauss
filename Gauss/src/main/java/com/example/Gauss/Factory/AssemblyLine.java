package com.example.Gauss.Factory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class AssemblyLine extends Thread {
    private final BlockingQueue<Component> buffer;
    private final Semaphore semaphore;

    public AssemblyLine(BlockingQueue<Component> buffer, Semaphore semaphore) {
        this.buffer = buffer;
        this.semaphore = semaphore;
    }

    // This method simulates the assembly line in a factory
    @Override
    public void run() {
        try {
            while (true) {
                semaphore.acquire();
                Component component = buffer.take();
                System.out.println("Assembled: " + component.getName());
                semaphore.release();
                Thread.sleep(1500); // Simulate time taken to assemble a component
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
