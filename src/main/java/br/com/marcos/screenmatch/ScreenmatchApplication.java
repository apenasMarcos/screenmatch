package br.com.marcos.screenmatch;

import br.com.marcos.screenmatch.model.EpisodeData;
import br.com.marcos.screenmatch.model.SerieData;
import br.com.marcos.screenmatch.service.ApiConsumer;
import br.com.marcos.screenmatch.service.ConvertData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var apiConsumer = new ApiConsumer();
		ConvertData convertData = new ConvertData();
		var serieJson = apiConsumer.getResponseBodyAsString("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		SerieData serieData = convertData.obtainData(serieJson, SerieData.class);
		System.out.println(serieData);

		var EpisodeJson = apiConsumer.getResponseBodyAsString("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
		EpisodeData episodeData = convertData.obtainData(EpisodeJson, EpisodeData.class);

		System.out.println(episodeData);
	}
}
