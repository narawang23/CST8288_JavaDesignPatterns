package com.wang.lab1.Beans;

public class Motorcycle extends Vehicle {
    public Motorcycle(String make, String model, int year) {
        super(make, model, year);
    }

    @Override
    public void start() {
        System.out.println("A Motorcycle starts");
    }

    @Override
    public void stop() {
        System.out.println("A Motorcycle stops");

    }
}

