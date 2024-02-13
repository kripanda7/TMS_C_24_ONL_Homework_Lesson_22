package by.teachmeskills.lesson41.service;

import by.teachmeskills.lesson41.dto.CarDto;
import by.teachmeskills.lesson41.mapper.CarMapper;
import by.teachmeskills.lesson41.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public List<CarDto> getCars() {
        return carRepository.findAll().stream().map(carMapper::toDTO).toList();
    }

    public CarDto save(CarDto carDto) {
        return carMapper.toDTO(carRepository.save(carMapper.toModel(carDto)));
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    public CarDto getCarById(Long id) {
        return carMapper.toDTO(carRepository.findById(id).get());
    }

    public void update(CarDto carDto) {
        carRepository.findById(carDto.getId()).ifPresent(car -> {
            carMapper.updateCustomerFromDto(carDto, car);
            carRepository.save(car);
        });
    }
}
