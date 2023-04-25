package ssau.project.svetkakoketkabot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "kinopoisk")
public class KinopoiskConfig {

    private String token;
}
