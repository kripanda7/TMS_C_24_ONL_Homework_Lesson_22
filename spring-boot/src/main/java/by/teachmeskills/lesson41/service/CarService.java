package by.teachmeskills.lesson41.service;

import by.teachmeskills.lesson41.dao.PostgreSQLJDBC;
import by.teachmeskills.lesson41.dto.CarDto;
import by.teachmeskills.lesson41.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CarService {

    private final PostgreSQLJDBC postgreSQLJDBC;
    private final CarMapper carMapper;

    public List<CarDto> getCars() {
        return postgreSQLJDBC.getCars().stream().map(carMapper::toDTO).toList();
    }

    public void save(CarDto carDto) {
        postgreSQLJDBC.saveCar(carMapper.toModel(carDto));
    }

    public void delete(Long id) {
        postgreSQLJDBC.deleteCar(id);
    }

    public CarDto getCarById(Long id) {
        return carMapper.toDTO(postgreSQLJDBC.getCarById(id));
    }

    public void update(CarDto carDto) {
        postgreSQLJDBC.updateCar(carMapper.toModel(carDto));
    }
}
