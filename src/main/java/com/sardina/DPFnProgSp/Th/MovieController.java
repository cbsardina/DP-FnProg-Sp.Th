package com.sardina.DPFnProgSp.Th;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MovieController {

    // -- variables: URL, Route, + REST template --
    static final String MOVIE_URL = "https://api.themoviedb.org/3/movie";
    static final String API_KEY = "?api_key=be2a38521a7859c95e2d73c48786e4bb";
    static final String NP_ROUTE = "/now_playing";
    static final String POPULAR_ROUTE = "/medium-popular-long-name";
    static RestTemplate restTemp = new RestTemplate();

    // -- ROUTES --
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homeMovie() {
        return "home";
    }

    @RequestMapping(path = "/now-playing", method = RequestMethod.GET)
    public String nowPlaying(Model model) {
        List<Movie> movies = getMovies(MOVIE_URL + NP_ROUTE + API_KEY);
        model.addAttribute("movies", movies);

        return "now-playing";
    }

    @RequestMapping(path = "/medium-popular-long-name", method = RequestMethod.GET)
    public String mediumPopularLongName(Model model) {
        List<Movie> movies = getMovies(MOVIE_URL + POPULAR_ROUTE + API_KEY);
        List<Movie> selectMovies = movies.stream()
                .filter(movie -> movie.title.length() >= 10 && movie.getPopularity() >= 30 && movie.getPopularity() <=80)
                .collect(Collectors.toList());
        model.addAttribute("selectMovies", selectMovies);

        return "medium-popular-long-name";
    }

    //-- getMovies() method --
    public static List<Movie> getMovies(String route) {

        Results movieResults = restTemp.getForObject(MOVIE_URL + NP_ROUTE + API_KEY, Results.class);
        return movieResults.getResults();
    }

}
