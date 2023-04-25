package ssau.project.svetkakoketkabot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import ssau.project.svetkakoketkabot.config.SvetkaConfig;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties({SvetkaConfig.class})
public class SvetkaKoketkaBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(SvetkaKoketkaBotApplication.class, args);
    }

}
