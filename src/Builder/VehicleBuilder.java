package Builder;

import Beans.Vehicle;

public interface VehicleBuilder {
    VehicleBuilder setMake(String make);
    VehicleBuilder setModel(String model);
    VehicleBuilder setYear(int year);
    Vehicle build();
}

