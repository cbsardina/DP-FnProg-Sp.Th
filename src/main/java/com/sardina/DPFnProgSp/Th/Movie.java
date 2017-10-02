package com.sardina.DPFnProgSp.Th;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    private String title;
    @JsonProperty(value = "poster_path")
    private String posterPath;
    private String overview;
    private double popularity;

    // -- BEAN --
    public Movie() {}

    // -- Getters/Setters --

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getPosterPath() { return posterPath; }

    public void setPosterPath(String posterPath) { this.posterPath = posterPath; }

    public String getOverview() { return overview; }

    public void setOverview(String overview) { this.overview = overview; }

    public double getPopularity() { return popularity; }

    public void setPopularity(double popularity) { this.popularity = popularity; }

    // -- override toString() --
    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                '}';
    }
}