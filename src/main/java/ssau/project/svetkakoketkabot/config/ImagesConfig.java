package ssau.project.svetkakoketkabot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.security.PrivateKey;
import java.util.Map;

@Component
@Data
@ConfigurationProperties(prefix = "image")
public class ImagesConfig {

    private static final String START_KEY = "start";
    private static final String DEFAULT_KEY = "default";
    private static final String NO_ANIME_PHOTO = "no-anime-photo";

    private Map<String, String> images;

    public String getStartImage(){
        return images.get(START_KEY);
    }

    public String getDefaultImage(){
        return images.get(DEFAULT_KEY);
    }

    public String getNoAnimePhoto(){
        return images.get(NO_ANIME_PHOTO);
    }
}
