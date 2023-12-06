package by.teachmeskills.lesson31.facade;

public class OrderFacade {
    public void makeOrder(Long productId) {
        OrderService orderService = new OrderService();
        Order order = orderService.createOrder(productId);
        if (orderService.isExist(order.getProduct().getId())) {
            PaymentsService paymentsService = new PaymentsService();
            paymentsService.pay(123L);
            DeliveryService deliveryService = new DeliveryService();
            deliveryService.deliver(order.getId());
            System.out.println("Order is successfully payed and shipped.");
        } else {
            System.out.println("This product is not exist.");
        }
    }
}
