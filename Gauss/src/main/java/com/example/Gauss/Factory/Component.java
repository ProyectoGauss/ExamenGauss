package com.example.Gauss.Factory;


// This class represents a component that is used in the factory
public class Component {
    private final String name;

    public Component(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
