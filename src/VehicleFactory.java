import Beans.Car;
import Beans.Vehicle;

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
