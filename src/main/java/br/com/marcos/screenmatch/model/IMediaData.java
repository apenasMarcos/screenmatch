package br.com.marcos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public interface IMediaData {
    @JsonAlias("imdbRating")
    String rating();

    @JsonAlias("Title")
    String title();
}

