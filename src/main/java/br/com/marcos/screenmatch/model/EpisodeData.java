package br.com.marcos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;


public record EpisodeData (String title,
                           String rating,
                           @JsonAlias("Episode") int episodeNumber,
                           @JsonAlias("Released") String releaseDate) implements IMediaData  {
}