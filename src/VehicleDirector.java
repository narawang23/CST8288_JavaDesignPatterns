// Create a VehicleDirector class that takes a builder and constructs a vehicle.

import Beans.Vehicle;
import Builder.VehicleBuilder;

class VehicleDirector {
    private VehicleBuilder builder;

    public VehicleDirector(VehicleBuilder builder) {
        this.builder = builder;
    }

    public Vehicle construct(String make, String model, int year) {
        return builder.setMake(make).setModel(model).setYear(year).build();
    }
}
