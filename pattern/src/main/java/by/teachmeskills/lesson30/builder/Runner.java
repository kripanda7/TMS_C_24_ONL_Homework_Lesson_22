package by.teachmeskills.lesson30.builder;

public class Runner {
    public static void main(String[] args) {
        Car johnsCar = Car.builder()
                .brand("VW")
                .model("Golf")
                .hP(150)
                .seats(5)
                .build();
        Car tomsCar = Car.builder()
                .brand("Nissan")
                .model("GTR")
                .hP(250)
                .seats(2)
                .wheels(4)
                .build();
        Car lizasCar = Car.builder()
                .seats(3)
                .wheels(6)
                .build();
        System.out.println("John's car: " + johnsCar.toString());
        System.out.println("Tom's car: " + tomsCar.toString());
        System.out.println("Liza's car: " + lizasCar.toString());
    }
}
