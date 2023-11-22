package by.teachmeskills.lesson30.abstractFactory;

public class TruckCar implements Car {
    @Override
    public void passengerTransportation() {
        System.out.println("Passenger transportation is impossible");
    }

    @Override
    public void deliver() {
        System.out.println("Delivering is possible");
    }
}
