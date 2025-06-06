package br.com.marcos.screenmatch.controller;

import br.com.marcos.screenmatch.service.SeriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/api")
public class MainController {

    private final SeriesService seriesService;

    public MainController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }


    @GetMapping("/series/{name}")
    public ResponseEntity<?> findSeriesByName(@PathVariable String name) {
        return ResponseEntity.ok(seriesService.findSeriesByName(name));
    }

    @GetMapping("/series/{name}/seasons")
    public ResponseEntity<?> listSeasonsBySeries(@PathVariable String name) {
        return ResponseEntity.ok(seriesService.listSeasonsBySeries(name));
    }

}