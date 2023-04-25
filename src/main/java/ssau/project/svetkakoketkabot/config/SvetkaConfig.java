package ssau.project.svetkakoketkabot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Data
@ConfigurationProperties(prefix = "bot")
public class SvetkaConfig {

    private String name;

    private String token;


}
