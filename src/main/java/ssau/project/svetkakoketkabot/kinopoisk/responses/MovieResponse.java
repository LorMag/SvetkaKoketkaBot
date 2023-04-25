package ssau.project.svetkakoketkabot.kinopoisk.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ssau.project.svetkakoketkabot.kinopoisk.objects.Movie;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {
    private List<Movie> docs;
    private int total;
    private int limit;
    private int page;
    private int pages;


}
