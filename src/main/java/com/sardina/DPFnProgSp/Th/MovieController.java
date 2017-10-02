package com.sardina.DPFnProgSp.Th;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    static final String NOW_PLAYING = "https://api.themoviedb.org/3/movie/now_playing?api_key=be2a38521a7859c95e2d73c48786e4bb";

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homeMovie() {
        return "home";
    }

    @RequestMapping(path = "/now-playing", method = RequestMethod.GET)
    public String nowPlaying() {

        //TODO: Pick up here
        return "now-playing";
    }

    @RequestMapping(path = "/medium-popular-long-name", method = RequestMethod.GET)
    public String mediumPopularLongName() {
        return "medium-popular-long-name";
    }


    public static List<Movie> getMovies(String route) {
        List<Movie> movieList = new ArrayList<>();
        RestTemplate restTemp = new RestTemplate();
        restTemp.getForObject(route, Movie.class);
        return movieList;

    }

}
