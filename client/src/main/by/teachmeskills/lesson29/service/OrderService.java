package by.teachmeskills.lesson29.service;

import by.teachmeskills.lesson29.dto.InternalProduct;
import by.teachmeskills.lesson29.dto.Order;
import by.teachmeskills.lesson29.dto.Product;

import java.util.List;

public class OrderService {

    public void printOrders(List<Order> orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public List<Order> generateOrder() {
        return List.of(
                Order.builder().id(1L).products(
                        List.of(Product.builder().id(1L).name("milk").build(),
                                InternalProduct.builder().purpose("internal").build())
                ).build());
    }
}
