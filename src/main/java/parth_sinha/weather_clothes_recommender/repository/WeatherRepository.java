package parth_sinha.weather_clothes_recommender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parth_sinha.weather_clothes_recommender.model.WeatherData;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherData, Long> {
}
