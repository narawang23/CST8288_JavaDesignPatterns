package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleFactoryTest {

    @Test
    public void testCreateCar() {
        Vehicle car = VehicleFactory.createVehicle("car","Honda","CRV",2023);
        assertNotNull(car);
        assertTrue(car instanceof Car);
        assertEquals("Toyota", car.getMake());
        assertEquals("Camry", car.getModel());
        assertEquals(2020, car.getYear());
    }

    @Test
    public void testCreateMotorcycle() {
        Vehicle motorcycle = VehicleFactory.createVehicle("motorcycle");
        assertNotNull(motorcycle);
        assertTrue(motorcycle instanceof Motorcycle);
        assertEquals("Yamaha", motorcycle.getMake());
        assertEquals("R1", motorcycle.getModel());
        assertEquals(2019, motorcycle.getYear());
    }

    @Test
    public void testCreateUnknownVehicle() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            VehicleFactory.createVehicle("truck");
        });

        String expectedMessage = "Unknown vehicle type: truck";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
