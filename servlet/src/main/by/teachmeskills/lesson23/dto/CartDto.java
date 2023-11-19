package by.teachmeskills.lesson23.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartDto {
    private List<ProductDto> products;
    private UserDto user;
}
