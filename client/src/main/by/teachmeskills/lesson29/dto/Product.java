package by.teachmeskills.lesson29.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}
