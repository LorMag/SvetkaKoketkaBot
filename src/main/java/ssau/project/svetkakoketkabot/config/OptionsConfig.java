package ssau.project.svetkakoketkabot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.bots.DefaultBotOptions;

@Configuration
public class OptionsConfig {

    @Bean
    public DefaultBotOptions defaultBotOptions(){
        return new DefaultBotOptions();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    };
}
