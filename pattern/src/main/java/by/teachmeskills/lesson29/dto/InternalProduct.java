package by.teachmeskills.lesson29.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class InternalProduct extends Product {
    private String purpose;
}
