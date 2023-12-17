package by.teachmeskills.lesson35.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {
    private Long id;
    private String fullName;
    private Integer age;
    private String address;
}
