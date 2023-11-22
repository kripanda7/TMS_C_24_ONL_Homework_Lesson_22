package by.teachmeskills.lesson30.abstractFactory;

public class PassengerTransportFactory implements TransportAbstractFactory {
    @Override
    public Car createCar() {
        return new Bus();
    }

    @Override
    public Plane createPlane() {
        return new PassengerPlane();
    }
}
