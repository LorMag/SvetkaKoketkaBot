package ssau.project.svetkakoketkabot.kinopoisk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ssau.project.svetkakoketkabot.config.KinopoiskConfig;
import ssau.project.svetkakoketkabot.kinopoisk.responses.MovieResponse;

@Component
public class Communication {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private KinopoiskConfig kinopoiskConfig;

    private static final int ANIME_RIGHT_LIM = 555; // максимальное количество страниц с такими параметрами запросов
    private static final int FILM_RIGHT_LIM = 1000; // максимальное число страниц с фильмами
    private static final String RANDOM_URL = "https://api.kinopoisk.dev/v1/movie?selectFields=rating.kp&selectFields=rating.imdb&selectFields=name&selectFields=description&selectFields=shortDescription&selectFields=year&selectFields=poster.url&selectFields=genres.name&selectFields=alternativeName&page=";


    public MovieResponse getRandomAnimeResponse(){


        StringBuilder ANIME_URL = new StringBuilder(RANDOM_URL);
        ANIME_URL.append(getRandomNumber(ANIME_RIGHT_LIM)).append("&limit=10&typeNumber=4");


        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        headers.add("X-API-KEY", kinopoiskConfig.getToken());

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<MovieResponse> responseEntity =
                restTemplate.exchange(ANIME_URL.toString(), HttpMethod.GET, entity,
                        new ParameterizedTypeReference<MovieResponse>() {});

        return responseEntity.getBody();
    }

    public MovieResponse getRandomFilmResponse(){


        StringBuilder FILM_URL = new StringBuilder(RANDOM_URL);
        FILM_URL.append(getRandomNumber(FILM_RIGHT_LIM)).append("&limit=10&typeNumber=1");


        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        headers.add("X-API-KEY", kinopoiskConfig.getToken());

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<MovieResponse> responseEntity =
                restTemplate.exchange(FILM_URL.toString(), HttpMethod.GET, entity,
                        new ParameterizedTypeReference<MovieResponse>() {});

        return responseEntity.getBody();
    }

    public int getRandomNumber(int rightLim){
        return 1 + (int) (Math.random() * rightLim);
    }

}
