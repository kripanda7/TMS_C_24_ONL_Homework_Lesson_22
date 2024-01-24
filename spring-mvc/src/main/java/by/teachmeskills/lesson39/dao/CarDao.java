package by.teachmeskills.lesson39.dao;

import by.teachmeskills.lesson39.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarDao {
    List<Car> getCars();

    Optional<Car> getCarById(Long id);

    void saveCar(Car car);

    void updateCar(Car car);

    void deleteCar(Long id);
}
