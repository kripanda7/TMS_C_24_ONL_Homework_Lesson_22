package by.teachmeskills.lesson41.mapper;

import by.teachmeskills.lesson41.dto.CarDto;
import by.teachmeskills.lesson41.model.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarDto toDTO(Car model);

    Car toModel(CarDto dto);
}
