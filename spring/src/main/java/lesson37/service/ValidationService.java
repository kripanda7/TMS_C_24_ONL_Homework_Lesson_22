package lesson37.service;

import org.springframework.stereotype.Component;

@Component
public class ValidationService {
    public boolean isValid(Long id) {
        return id.intValue() % 2 == 0;
    }
}
