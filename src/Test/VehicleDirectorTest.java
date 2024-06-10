package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleDirectorTest {
    private VehicleDirector director;
    private CarBuilder carBuilder;

    @BeforeEach
    public void setUp() {
        carBuilder = new CarBuilder();
        director = new VehicleDirector(carBuilder);
    }

    @Test
    public void testConstructVehicle() {
        Vehicle car = director.constructVehicle();
        assertNotNull(car);
        assertEquals("V8 Engine", car.getEngine());
        assertEquals(4, car.getWheels());
    }
}

