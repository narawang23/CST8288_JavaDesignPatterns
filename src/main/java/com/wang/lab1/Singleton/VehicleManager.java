package com.wang.lab1.Singleton;

import com.wang.lab1.Beans.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleManager {
    /* private static variable that stores reference to single instance of VehicleManager */
   private static VehicleManager instance;
    private List<Vehicle> vehicles;

    /* Private constructor, so no other class can call it and create other instances */
    private VehicleManager() {
        vehicles = new ArrayList<>();
    }
    /* Static method that returns reference to single instance.
     * Initializes it only once, if not initialized before */
    public static VehicleManager getInstance() {
        if (instance == null) {
            instance = new VehicleManager();
        }
        return instance;
    }
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

}
