package com.wang.lab1.Beans;

public class Car extends Vehicle {
    public Car(String make, String model, int year) {
        super(make, model, year);
    }

    @Override
    public void start() {
        System.out.println("A car starts");
    }

    @Override
    public void stop() {
        System.out.println("A car stops");
    }
}

