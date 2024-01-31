package by.teachmeskills.lesson41.dao;

import by.teachmeskills.lesson41.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarDao {
    List<Car> getCars();

    Optional<Car> getCarById(Long id);

    Car saveCar(Car car);

    void updateCar(Car car);

    void deleteCar(Long id);
}
