package by.teachmeskills.lesson30.singleton;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppConfig {
    private String appName;
    private String location;
    private BigDecimal memory;
    private static final AppConfig INSTANCE = new AppConfig("Singleton", "local", new BigDecimal(1000));

    public static AppConfig getInstance() {
        return INSTANCE;
    }
}
