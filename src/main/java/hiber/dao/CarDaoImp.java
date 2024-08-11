package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;

@Repository
public class CarDaoImp implements CarDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }
    @Transactional
    @Override
    public Car getCarByModelAndSeries(String model, int series) {
        String hql = "from Car where model = :model and series = :series";
        return sessionFactory.getCurrentSession().createQuery(hql, Car.class).setParameter("model", model).setParameter("series", series).uniqueResult();
    }
}
