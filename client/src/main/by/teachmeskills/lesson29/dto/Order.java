package by.teachmeskills.lesson29.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class Order {
    private Long id;
    private BigDecimal totalPrice;
    private List<Product> products;

    public BigDecimal getTotalPrice() {
        return ((BigDecimal) products.stream().map(Product::getPrice)).plus();
    }
}
