package by.teachmeskills.lesson30.factoryMethod;

public class Runner {
    public static void main(String[] args) {
        Delivery landDelivery = new LandDelivery();
        landDelivery.deliver();
        Delivery seaDelivery = new SeaDelivery();
        seaDelivery.deliver();
    }
}
