package by.teachmeskills.lesson39.service;

import by.teachmeskills.lesson39.dao.PostgreSQLJDBC;
import by.teachmeskills.lesson39.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CarService {

    private final PostgreSQLJDBC postgreSQLJDBC;

    public List<Car> getCars() {
        return postgreSQLJDBC.getCars();
    }

    public void save(Car car) {
        postgreSQLJDBC.saveCar(car);
    }

    public void delete(Long id) {
        postgreSQLJDBC.deleteCar(id);
    }

    public Car getCarById(Long id) {
        return postgreSQLJDBC.getCarById(id);
    }

    public void update(Car car) {
        postgreSQLJDBC.updateCar(car);
    }
}
