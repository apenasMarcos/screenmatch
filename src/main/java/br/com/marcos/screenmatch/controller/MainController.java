package br.com.marcos.screenmatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.screenmatch.service.SerieService;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private SeriesService seriesService;

    @GetMapping("/series")
    public ResponseEntity<?> listSeries() {
        return ResponseEntity.ok(seriesService.listSeries());
    }

    @GetMapping("/series/{id}")
    public ResponseEntity<?> findSeriesById(@PathVariable Long id) {
        return ResponseEntity.ok(seriesService.findSeriesById(id));
    }

    @GetMapping("/series/{id}/seasons")
    public ResponseEntity<?> listSeasonsBySeries(@PathVariable Long id) {
        return ResponseEntity.ok(seriesService.listSeasonsBySeries(id));
    }

    @GetMapping("/series/{id}/seasons/{seasonId}/episodes")
    public ResponseEntity<?> listEpisodesBySeason(@PathVariable Long id, @PathVariable Long seasonId) {
        return ResponseEntity.ok(seriesService.listEpisodesBySeason(id, seasonId));
    }
}