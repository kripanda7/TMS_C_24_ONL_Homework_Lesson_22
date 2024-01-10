package by.teachmeskills.lesson41.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "database")
public class DBProperties {
    String url;
    String user;
    String password;
}
