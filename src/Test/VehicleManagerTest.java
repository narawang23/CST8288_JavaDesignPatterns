package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleManagerTest {

    private VehicleManager manager;

    @BeforeEach
    public void setUp() {
        // This method will be run before each test
        manager = VehicleManager.getInstance();
        // Clear the vehicles list before each test to ensure isolation
        manager.getVehicles().clear();
    }

    @AfterEach
    public void tearDown() {
        // This method will be run after each test
        // Any necessary cleanup can be done here
        manager.getVehicles().clear();
    }

    @Test
    public void testSingleton() {
        VehicleManager manager1 = VehicleManager.getInstance();
        VehicleManager manager2 = VehicleManager.getInstance();
        assertSame(manager1, manager2);
    }

    @Test
    public void testAddVehicle() {
        Vehicle car = new Car("Toyota", "Camry", 2020);
        manager.addVehicle(car);
        assertTrue(manager.getVehicles().contains(car));
    }
}
