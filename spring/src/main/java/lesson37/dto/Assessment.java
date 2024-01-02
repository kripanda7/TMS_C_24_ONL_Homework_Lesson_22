package lesson37.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Assessment {
    private Long id;
    private String description;
}
