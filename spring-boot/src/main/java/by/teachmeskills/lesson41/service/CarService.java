package by.teachmeskills.lesson41.service;

import by.teachmeskills.lesson41.dao.CarDao;
import by.teachmeskills.lesson41.dto.CarDto;
import by.teachmeskills.lesson41.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CarService {

    private final CarDao carDao;
    private final CarMapper carMapper;

    public List<CarDto> getCars() {
        return carDao.getCars().stream().map(carMapper::toDTO).toList();
    }

    public void save(CarDto carDto) {
        carDao.saveCar(carMapper.toModel(carDto));
    }

    public void delete(Long id) {
        carDao.deleteCar(id);
    }

    public CarDto getCarById(Long id) {
        return carMapper.toDTO(carDao.getCarById(id).get());
    }

    public void update(CarDto carDto) {
        carDao.updateCar(carMapper.toModel(carDto));
    }
}
