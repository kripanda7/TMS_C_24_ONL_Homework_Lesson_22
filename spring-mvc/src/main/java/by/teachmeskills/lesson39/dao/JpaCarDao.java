package by.teachmeskills.lesson39.dao;

import by.teachmeskills.lesson39.entity.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaCarDao implements CarDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Car> getCars() {
        return entityManager.createNamedQuery("Car.selectAll", Car.class).getResultList();
    }

    @Override
    public Optional<Car> getCarById(Long id) {
        return Optional.ofNullable(entityManager.find(Car.class, id));
    }

    @Override
    public void saveCar(Car car) {
        entityManager.persist(car);
    }

    @Override
    public void updateCar(Car car) {
        entityManager.merge(car);
    }

    @Override
    public void deleteCar(Long id) {
        getCarById(id).ifPresent(car -> {
            car.setDeleted(true);
            entityManager.merge(car);
        });
    }
}
