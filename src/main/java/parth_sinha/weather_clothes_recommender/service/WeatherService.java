package parth_sinha.weather_clothes_recommender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import parth_sinha.weather_clothes_recommender.model.WeatherData;
import parth_sinha.weather_clothes_recommender.repository.WeatherRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONObject;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private String apiKey;

    private static final String BASE_URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";

    @Autowired
    private WeatherRepository weatherRepository;

    public WeatherData getWeather(String location) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String currentTime = now.format(formatter);

        String apiUrl = BASE_URL + location + "/" + currentTime + "?key=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(apiUrl, String.class);

        JSONObject jsonObject = new JSONObject(result);
        double temp = jsonObject.getJSONArray("days").getJSONObject(0).getDouble("temp");
        String description = jsonObject.getJSONArray("days").getJSONObject(0).getString("description");
        LocalDateTime date = now;

        WeatherData weatherData = new WeatherData();
        weatherData.setLocation(location);
        weatherData.setDate(date.toLocalDate());
        weatherData.setTemp(temp);
        weatherData.setWeatherDescription(description);
        weatherRepository.save(weatherData);

        return weatherData;
    }
}

