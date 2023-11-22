package by.teachmeskills.lesson30.factoryMethod;

public class SeaDelivery implements Delivery {
    private static final Transport TRANSPORT = new Ship();

    @Override
    public void deliver() {
        TRANSPORT.deliver();
    }
}
