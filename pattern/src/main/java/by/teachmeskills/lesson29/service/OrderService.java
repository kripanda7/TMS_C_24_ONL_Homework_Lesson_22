package by.teachmeskills.lesson29.service;

import by.teachmeskills.lesson29.Runner;
import by.teachmeskills.lesson29.dto.InternalProduct;
import by.teachmeskills.lesson29.dto.Order;
import by.teachmeskills.lesson29.dto.Product;
import org.apache.log4j.Logger;

import java.util.List;

public class OrderService {
    private static final Logger LOGGER = Logger.getLogger(OrderService.class);
    public void printOrders(List<Order> orders) {
        for (Order order : orders) {
            LOGGER.info(order);
        }
    }

    public List<Order> generateOrder() {
        return List.of(
                Order.builder().id(1L).products(
                        List.of(Product.builder().id(1L).name("milk").build(),
                                new InternalProduct())
                ).build());
    }
}
