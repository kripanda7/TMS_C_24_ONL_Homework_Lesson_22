package by.teachmeskills.lesson30.factoryMethod;

public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivery cargo by truck.");
    }
}
