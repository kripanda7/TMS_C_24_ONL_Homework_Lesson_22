package by.teachmeskills.lesson29.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class InternalProduct extends Product {
    private String purpose;
}
