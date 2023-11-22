package by.teachmeskills.lesson30.abstractFactory;

public class Runner {
    public static void main(String[] args) {
        boolean isPassengerDelivery = true;
        TransportAbstractFactory factory = isPassengerDelivery ? new PassengerTransportFactory() : new CargoTransportFactory();
        Car transport = factory.createCar();
        transport.passengerTransportation();
        transport.deliver();
    }
}
