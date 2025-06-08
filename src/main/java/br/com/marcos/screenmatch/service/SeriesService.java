package br.com.marcos.screenmatch.service;

import br.com.marcos.screenmatch.model.EpisodeData;
import br.com.marcos.screenmatch.model.SeasonData;
import br.com.marcos.screenmatch.model.SerieData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class SeriesService {

    private final ApiConsumer apiConsumer = new ApiConsumer();

    private final ConvertData convertData = new ConvertData();

    @Value("${api.key}")
    private String API_KEY;

    private final String URL = "https://www.omdbapi.com/?apikey=" + API_KEY + "&t=";


    private static <T> T fetchData(ApiConsumer apiConsumer, ConvertData convertData, String url, Class<T> clazz) {
        String json = apiConsumer.getResponseBodyAsString(url);
        return convertData.obtainData(json, clazz);
    }

    public SerieData findSeriesByName(String seriesName) {
        return fetchData(apiConsumer, convertData, URL + seriesName, SerieData.class);
    }

    public Object listSeasonsBySeries(String name) {
        SerieData seriesData = fetchData(apiConsumer, convertData, URL + name, SerieData.class);
        List<SeasonData> seasonDataList = new ArrayList<>();
        IntStream.range(1, seriesData.totalSeasons() + 1)
                .boxed()
                .forEach(i -> {
                    SeasonData seasonData = fetchData(apiConsumer, convertData, URL + name + "&season=" + i, SeasonData.class);
                    seasonDataList.add(seasonData);
                });

        return seasonDataList.stream()
                .flatMap(seasonData -> seasonData.episodes().stream())
                .map(EpisodeData::title)
                .toList();
    }
}