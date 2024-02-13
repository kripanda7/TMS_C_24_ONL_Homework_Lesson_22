package by.teachmeskills.lesson41.mapper;

import by.teachmeskills.lesson41.dto.CarDto;
import by.teachmeskills.lesson41.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarDto toDTO(Car model);

    Car toModel(CarDto dto);

    void updateCustomerFromDto(CarDto dto, @MappingTarget Car entity);
}
