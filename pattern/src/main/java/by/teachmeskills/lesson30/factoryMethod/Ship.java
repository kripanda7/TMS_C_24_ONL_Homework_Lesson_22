package by.teachmeskills.lesson30.factoryMethod;

public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivery cargo by ship.");
    }
}
