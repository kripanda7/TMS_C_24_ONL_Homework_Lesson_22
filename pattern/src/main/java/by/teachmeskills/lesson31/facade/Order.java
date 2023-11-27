package by.teachmeskills.lesson31.facade;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private Long id;
    private Product product;
}
