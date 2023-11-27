package by.teachmeskills.lesson31.facade;

public class OrderService {
    public Order createOrder(Long productId) {
        return Order.builder().product(Product.builder().id(productId).name("Toolkit").build()).build();
    }

    public boolean isExist(Long productId) {
        return productId.equals(1L);
    }
}
