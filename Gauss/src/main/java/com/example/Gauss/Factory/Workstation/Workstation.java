package com.example.Gauss.Factory.Workstation;

import com.example.Gauss.Factory.Component.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class Workstation extends Thread {
    private final BlockingQueue<Component> buffer;
    private final String componentName;
    private final Semaphore semaphore;

    //constructor de la clase
    public Workstation(BlockingQueue<Component> buffer, String componentName, Semaphore semaphore) {
        this.buffer = buffer;
        this.componentName = componentName;
        this.semaphore = semaphore;
    }


    //este metodo es el que se encarga de producir los componentes
    @Override
    public void run() {
        try {
            while (true) {
                semaphore.acquire();
                Component component = new Component(componentName);
                buffer.put(component);
                System.out.println("Produced: " + component.getName());
                semaphore.release();
                Thread.sleep(1000); // Simulate time taken to produce a component
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
