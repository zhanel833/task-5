package hiber.dao;

import hiber.model.Car;

public interface CarDao {
    void add(Car car);
    Car getCarByModelAndSeries(String model, int series);
}
