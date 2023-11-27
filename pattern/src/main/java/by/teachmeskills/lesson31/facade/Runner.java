package by.teachmeskills.lesson31.facade;

public class Runner {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.makeOrder(1L);
    }
}
