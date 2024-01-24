package by.teachmeskills.lesson39.service;

import by.teachmeskills.lesson39.dao.CarDao;
import by.teachmeskills.lesson39.dto.CarDto;
import by.teachmeskills.lesson39.mapper.CarMapper;
import by.teachmeskills.lesson39.entity.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class CarService {

    private final CarDao hibernateCarDao;
    private final CarMapper carMapper;

    public List<CarDto> getCars() {
        return hibernateCarDao.getCars().stream().map(carMapper::toDTO).toList();
    }

    public void save(CarDto carDto) {
        hibernateCarDao.saveCar(carMapper.toModel(carDto));
    }

    public void delete(Long id) {
        hibernateCarDao.deleteCar(id);
    }

    public CarDto getCarById(Long id) {
        return carMapper.toDTO(hibernateCarDao.getCarById(id).orElse(new Car()));
    }

    public void update(CarDto carDto) {
        hibernateCarDao.updateCar(carMapper.toModel(carDto));
    }
}
