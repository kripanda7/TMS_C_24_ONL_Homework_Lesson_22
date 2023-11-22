package by.teachmeskills.lesson30.abstractFactory;

public class CargoTransportFactory implements TransportAbstractFactory {
    @Override
    public Car createCar() {
        return new TruckCar();
    }

    @Override
    public Plane createPlane() {
        return new CargoPlane();
    }
}
