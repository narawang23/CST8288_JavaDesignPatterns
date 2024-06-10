import Beans.Vehicle;
import Builder.CarBuilder;
import Builder.MotorcycleBuilder;
import Builder.VehicleBuilder;

public class Main {
    public static void main(String[] args) {
        // Singleton VehicleManager
        VehicleManager vehicleManager = VehicleManager.getInstance();

        // Using Builder pattern to create vehicles
        VehicleBuilder carBuilder = new CarBuilder();
        VehicleDirector director = new VehicleDirector(carBuilder);
        Vehicle car = director.construct("Toyota", "Corolla", 2023);
        vehicleManager.addVehicle(car);

        VehicleBuilder motorcycleBuilder = new MotorcycleBuilder();
        director = new VehicleDirector(motorcycleBuilder);
        Vehicle motorcycle = director.construct("Honda", "x", 2024);
        vehicleManager.addVehicle(motorcycle);

        // Using Factory pattern to create vehicles
        Vehicle car2 = VehicleFactory.createVehicle("car", "Ford", "Focus", 2019);
        vehicleManager.addVehicle(car2);

        Vehicle motorcycle2 = VehicleFactory.createVehicle("motorcycle", "Yamaha", "MT-07", 2018);
        vehicleManager.addVehicle(motorcycle2);

        // Demonstrate Singleton
        VehicleManager anotherManager = VehicleManager.getInstance();
        System.out.println(vehicleManager == anotherManager); // should print true

        // List all vehicles
        for (Vehicle v : vehicleManager.getVehicles()) {
            System.out.println(v);
            v.start();
            v.stop();
        }
    }
}
