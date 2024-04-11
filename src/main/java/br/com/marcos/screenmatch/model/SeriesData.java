package br.com.marcos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesData (@JsonProperty("Title") String title,
        @JsonProperty("totalSeasons") Integer totalSeasons,
        @JsonProperty("imdbRating") String rating) {
}