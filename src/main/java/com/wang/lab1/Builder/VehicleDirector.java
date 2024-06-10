package com.wang.lab1.Builder;// Create a VehicleDirector class that takes a builder and constructs a vehicle.

import com.wang.lab1.Builder.VehicleBuilder;
import com.wang.lab1.Beans.Car;
import com.wang.lab1.Beans.Motorcycle;
import com.wang.lab1.Beans.Vehicle;

public class VehicleDirector {
    private VehicleBuilder builder;

    public VehicleDirector(VehicleBuilder builder) {
        this.builder = builder;
    }

    public Vehicle construct(String make, String model, int year) {
        return builder.setMake(make).setModel(model).setYear(year).build();
    }
}
