package parth_sinha.weather_clothes_recommender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import parth_sinha.weather_clothes_recommender.model.WeatherData;
import parth_sinha.weather_clothes_recommender.service.WeatherService;

@RestController
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather/{location}")
    public WeatherData getWeather(@PathVariable String location) {
        return weatherService.getWeather(location);
    }
}
