package Builder;

import Beans.Car;
import Beans.Vehicle;

public class CarBuilder implements VehicleBuilder {
    private String make;
    private String model;
    private int year;

    @Override
    public VehicleBuilder setMake(String make) {
        this.make = make;
        return this;
    }

    @Override
    public VehicleBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    @Override
    public VehicleBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    @Override
    public Vehicle build() {
        return new Car(make, model, year);
    }
}