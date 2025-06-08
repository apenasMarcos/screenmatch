package br.com.marcos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public record SerieData(String title,
                        String rating,
                        @JsonProperty("totalSeasons") Integer totalSeasons) implements IMediaData {
}