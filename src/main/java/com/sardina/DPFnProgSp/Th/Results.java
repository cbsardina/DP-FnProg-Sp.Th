package com.sardina.DPFnProgSp.Th;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
