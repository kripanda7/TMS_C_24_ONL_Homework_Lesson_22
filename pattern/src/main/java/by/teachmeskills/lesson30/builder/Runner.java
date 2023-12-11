package by.teachmeskills.lesson30.builder;

import org.apache.log4j.Logger;

public class Runner {
    private static final Logger LOGGER = Logger.getLogger(Runner.class);
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
        LOGGER.info("John's car: " + johnsCar.toString());
        LOGGER.info("Tom's car: " + tomsCar.toString());
        LOGGER.info("Liza's car: " + lizasCar.toString());
    }
}
