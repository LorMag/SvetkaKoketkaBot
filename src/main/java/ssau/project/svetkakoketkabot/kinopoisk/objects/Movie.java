package ssau.project.svetkakoketkabot.kinopoisk.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Rating{
        private double kp;
        private double imdb;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Poster{
        private String url;

    }

    @Data
    @NoArgsConstructor
    public static class Genre{

        private String name;

    }

    private String name;
    private String description;
    private String shortDescription;
    private String alternativeName;
    private int year;

    private Poster poster;
    private Rating rating;
    private List<Genre> genres;
    public void addNewPoster(String url){
        this.poster = new Poster(url);
    }

    public String getGenresString(){
        StringBuilder str = new StringBuilder();
        for (Genre g: genres){
            str.append(g.name).append(", ");
        }
        str.delete(str.length() - 2, str.length() - 1);
        return str.toString();
    }
}
