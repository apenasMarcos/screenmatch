package br.com.marcos.screenmatch.principal;

import br.com.marcos.screenmatch.model.EpisodeData;
import br.com.marcos.screenmatch.model.SeasonData;
import br.com.marcos.screenmatch.model.SerieData;
import br.com.marcos.screenmatch.service.ApiConsumer;
import br.com.marcos.screenmatch.service.ConvertData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Principal {

    private final Scanner inputScanner = new Scanner(System.in);

    private final ApiConsumer apiConsumer = new ApiConsumer();

    private final ConvertData convertData = new ConvertData();

    private final String URL = "https://www.omdbapi.com/?apikey=";


    public void displayMenu(){
        System.out.println("Enter the name of the series to search");

        String seriesName = inputScanner.nextLine().replace(" ", "+");
        SerieData seriesData = fetchData(apiConsumer, convertData, URL + "&t=" + seriesName, SerieData.class);

        System.out.println(seriesData);

        EpisodeData episodeData = fetchData(apiConsumer, convertData, URL + "&t=" + seriesName + "season=1&episode=1", EpisodeData.class);

        System.out.println(episodeData);

        List<SeasonData> seasonDataList = new ArrayList<>();
        IntStream.range(1, seriesData.totalSeasons() + 1)
                .boxed()
                .forEach(i -> {
                    SeasonData seasonData = fetchData(apiConsumer, convertData, URL + "&t=" + seriesName + i, SeasonData.class);
                    seasonDataList.add(seasonData);
                    System.out.println(seasonData);
                });
    }

    private static <T> T fetchData(ApiConsumer apiConsumer, ConvertData convertData, String url, Class<T> clazz) {
        String json = apiConsumer.getResponseBodyAsString(url);
        return convertData.obtainData(json, clazz);
    }
}
