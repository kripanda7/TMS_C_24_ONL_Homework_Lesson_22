package by.teachmeskills.lesson41.repository;

import by.teachmeskills.lesson41.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
