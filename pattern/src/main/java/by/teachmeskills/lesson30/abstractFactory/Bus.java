package by.teachmeskills.lesson30.abstractFactory;

public class Bus implements Car {
    @Override
    public void passengerTransportation() {
        System.out.println("Big amount of passenger transportation is possible");
    }

    @Override
    public void deliver() {
        System.out.println("Delivering is impossible");
    }
}
