package com.wang.lab1.Builder;
import com.wang.lab1.Beans.Vehicle;

/**
 * Create a VehicleDirector class that
 * takes a builder and constructs a vehicle.
 */
public class VehicleDirector {
    private VehicleBuilder builder;

    public VehicleDirector(VehicleBuilder builder) {
        this.builder = builder;
    }

    public Vehicle construct(String make, String model, int year) {
        return builder.setMake(make).setModel(model).setYear(year).build();
    }
}
