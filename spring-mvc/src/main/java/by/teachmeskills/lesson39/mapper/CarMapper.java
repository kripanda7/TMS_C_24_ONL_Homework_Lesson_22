package by.teachmeskills.lesson39.mapper;

import by.teachmeskills.lesson39.dto.CarDto;
import by.teachmeskills.lesson39.model.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarDto toDTO(Car model);

    Car toModel(CarDto dto);
}
