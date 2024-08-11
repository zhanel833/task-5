package hiber.service;

import hiber.model.Car;

public interface CarService {
    void add(Car car);
    Car getCarByModelAndSeries(String model, int series);
}
