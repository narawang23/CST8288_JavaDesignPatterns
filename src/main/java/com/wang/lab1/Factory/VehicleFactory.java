package com.wang.lab1.Factory;

import com.wang.lab1.Beans.Car;
import com.wang.lab1.Beans.Motorcycle;
import com.wang.lab1.Beans.Vehicle;

/**
 * simple factor design pattern: creates objects based on String input
 */

public class VehicleFactory {
    public static Vehicle createVehicle(String type, String make, String model, int year) {
        switch (type.toLowerCase()) {
            case "car":
                return new Car(make, model, year);
            case "motorcycle":
                return new Motorcycle(make, model, year);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}
