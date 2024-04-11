package br.com.marcos.screenmatch;

import br.com.marcos.screenmatch.model.SeriesData;
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
		var json = apiConsumer.getResponseBodyAsString("https://www.omdbapi.com/?t=gilmore+girls&apikey=");
		ConvertData convertData = new ConvertData();
		SeriesData data = convertData.obtainData(json, SeriesData.class);
		System.out.println(data);
	}
}
