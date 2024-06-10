package com.wang.lab1.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.wang.lab1.Factory.VehicleFactory;
import org.junit.jupiter.api.Test;

import com.wang.lab1.Beans.Car;
import com.wang.lab1.Beans.Motorcycle;
import com.wang.lab1.Beans.Vehicle;

public class VehicleFactoryTest {

    @Test
    public void testCreateCar() {
        Vehicle vehicle = VehicleFactory.createVehicle("car", "Toyota", "Corolla", 2022);
        assertEquals("Toyota", vehicle.getMake());
        assertEquals("Corolla", vehicle.getModel());
        assertEquals(2022, vehicle.getYear());
        assertEquals(Car.class, vehicle.getClass());
    }

    @Test
    public void testCreateMotorcycle() {
        Vehicle vehicle = VehicleFactory.createVehicle("motorcycle", "Honda", "CBR1000RR", 2022);
        assertEquals("Honda", vehicle.getMake());
        assertEquals("CBR1000RR", vehicle.getModel());
        assertEquals(2022, vehicle.getYear());
        assertEquals(Motorcycle.class, vehicle.getClass());
    }

    @Test
    public void testUnknownVehicleType() {
        assertThrows(IllegalArgumentException.class, () -> {
            VehicleFactory.createVehicle("bus", "Volvo", "XC90", 2022);
        });
    }
}
