package com.wang.lab1.test;

import com.wang.lab1.Builder.CarBuilder;
import com.wang.lab1.Builder.VehicleBuilder;
import com.wang.lab1.Beans.Vehicle;
import com.wang.lab1.Builder.VehicleDirector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class VehicleDirectorTest {

    private VehicleDirector vehicleDirector;
    private VehicleBuilder builder;

    @BeforeEach
    public void setUp() {
        builder = new CarBuilder();
        vehicleDirector = new VehicleDirector(builder);
    }

    @AfterEach
    public void tearDown() {
        builder = null;
        vehicleDirector = null;
    }

    @Test
    public void testConstruct() {
        Vehicle vehicle = vehicleDirector.construct("Toyota", "Corolla", 2022);
        assertEquals("Toyota", vehicle.getMake());
        assertEquals("Corolla", vehicle.getModel());
        assertEquals(2022, vehicle.getYear());
    }
}
