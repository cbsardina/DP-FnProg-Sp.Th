package com.sardina.DPFnProgSp.Th;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {

    List<Movie> results;

    // -- BEAN --
    public Results() { }

    public List<Movie> getResults() { return results; }



    @Override
    public String toString() {
        return "ResultsPage{" +
                "results=" + results +
                '}';
    }
}
