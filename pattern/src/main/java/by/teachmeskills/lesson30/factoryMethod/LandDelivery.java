package by.teachmeskills.lesson30.factoryMethod;

public class LandDelivery implements Delivery {
    private static final Transport TRANSPORT = new Truck();

    @Override
    public void deliver() {
        TRANSPORT.deliver();
    }
}
