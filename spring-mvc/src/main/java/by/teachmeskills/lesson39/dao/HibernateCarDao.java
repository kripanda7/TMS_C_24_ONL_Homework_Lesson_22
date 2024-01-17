package by.teachmeskills.lesson39.dao;

import by.teachmeskills.lesson39.entity.Car;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class HibernateCarDao implements CarDao {

    private final SessionFactory sessionFactory;

    @Override
    public List<Car> getCars() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("SELECT c FROM Car c where deleted = false order by id ASC", Car.class).getResultList();
    }

    @Override
    public Optional<Car> getCarById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return Optional.ofNullable(currentSession.get(Car.class, id));
    }

    @Override
    public void saveCar(Car car) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(car);
    }

    @Override
    public void updateCar(Car car) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(car);
    }

    @Override
    public void deleteCar(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        getCarById(id).ifPresent(car -> {
            car.setDeleted(true);
            currentSession.save(car);
        });
    }
}
