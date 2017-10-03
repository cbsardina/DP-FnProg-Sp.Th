package com.sardina.DPFnProgSp.Th;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MovieController {

    static final String MOVIE_URL = "https://api.themoviedb.org/3/movie";
    static final String API_KEY = "?api_key=be2a38521a7859c95e2d73c48786e4bb";
    static final String NP_ROUTE = "/now_playing";
    static final String POPULAR_ROUTE = "/medium-popular-long-name";


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homeMovie() {
        return "home";
    }

    @RequestMapping(path = "/now-playing", method = RequestMethod.GET)
    public String nowPlaying(Model model) {

        getMovies(MOVIE_URL + NP_ROUTE + API_KEY);
        return "now-playing";
    }

    @RequestMapping(path = "/medium-popular-long-name", method = RequestMethod.GET)
    public String mediumPopularLongName() {
        return "medium-popular-long-name";
    }


    public static List<Movie> getMovies(String route) {
        RestTemplate restTemp = new RestTemplate();
        Results movieResults = restTemp.getForObject(MOVIE_URL + NP_ROUTE + API_KEY, Results.class);

        return movieResults.getResults();
    }

}
