package by.teachmeskills.lesson39.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class Car {
    private Long id;
    @NotNull
    @Size(min = 2, max = 12)
    private String name;
    @NotNull
    @Min(1000)
    @Max(1000000)
    private Integer price;
}
