package com.wang.lab1.Builder;

import com.wang.lab1.Beans.Vehicle;

public interface VehicleBuilder {
    VehicleBuilder setMake(String make);
    VehicleBuilder setModel(String model);
    VehicleBuilder setYear(int year);
    Vehicle build();
}

