package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CarServiceImp implements CarService {
    @Autowired
    private CarDao carDao;

    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);
    }

    @Override
    public Car getCarByModelAndSeries(String model, int series) {

        return carDao.getCarByModelAndSeries(model, series);
    }
}
