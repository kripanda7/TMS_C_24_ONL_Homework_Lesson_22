package by.teachmeskills.lesson23.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {

    private final BigDecimal price;
    private final String name;
}
