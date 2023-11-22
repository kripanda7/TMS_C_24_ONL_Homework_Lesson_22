package by.teachmeskills.lesson30.builder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {
    private Integer wheels;
    private String engine;
    private boolean engineOn;
    private Integer hP;
    private Integer seats;
    private String brand;
    private String model;
}
