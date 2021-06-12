package de.hwr.moviebyweather.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.hwr.moviebyweather.model.*;
import de.hwr.moviebyweather.util.FieldMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/suggestion")
public class SuggestionController {

    Resource resource = new ClassPathResource("api.properties");

    @GetMapping
    public String greetingForm(Model model) {
        model.addAttribute("city", new City());
        model.addAttribute("movie", new Movie());
        return "suggestion";
    }

    @PostMapping
    public String enterCity(@ModelAttribute City city, ModelMap model) {

        model.addAttribute("zipCode", city.getZipCode());
        model.addAttribute("countryCode", city.getCountryCode());

        final String urlWeather = "https://api.openweathermap.org/data/2.5/weather/?zip={zip},{code}&appid={apiKey}";
        Map<String, ?> urlParametersWeather = null;
        String apiKeyWeather = null;
        try {
            apiKeyWeather = PropertiesLoaderUtils.loadProperties(resource).getProperty("OPEN_WEATHER_MAP_API_KEY");
        } catch (IOException e) {
            e.printStackTrace();
        }
            urlParametersWeather = Map.of(
                    "zip", city.getZipCode(),
                    "code", city.getCountryCode(),
                    "apiKey", apiKeyWeather);


        RestTemplate rest = new RestTemplate();
        final ObjectMapper mapper = new ObjectMapper();
        ResponseEntity<String> responseEntityWeather = rest.exchange(
                urlWeather,
                HttpMethod.GET,
                null,
                String.class,
                urlParametersWeather);

        JsonNode object = null;
        try {
            object = mapper.readTree(responseEntityWeather.getBody());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Weather weather = new Weather(
                object.get("weather").get(0).get("main").asText(),
                object.get("weather").get(0).get("description").asText());
        model.addAllAttributes(FieldMapper.toMap(weather));

        city.setName(object.get("name").asText());
        model.addAttribute("cityName", city.getName());

        final String urlMovie = "https://api.themoviedb.org/3/discover/movie?api_key={apiKey}&with_genres={genre}&page={pageNo}&include_adult=false&sort_by=popularity.desc";

        String apiKeyMovies = null;
        try {
            apiKeyMovies = PropertiesLoaderUtils.loadProperties(resource).getProperty("THE_MOVIE_DB_API_KEY");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, ?> urlParametersMoviePage = Map.of(
                "apiKey", apiKeyMovies,
                "genre", WeatherCondition.getGenreIdByConditionName(weather.getWeatherConditionShort()),
                "pageNo", 1);

        ResponseEntity<MoviePage> responseEntityMovie = rest.exchange(
                urlMovie,
                HttpMethod.GET,
                null,
                MoviePage.class,
                urlParametersMoviePage);

        int randomPage = new Random().nextInt(Math.round(responseEntityMovie.getBody().getTotalPages() / 10)) + 1;
        int randomEntry = new Random().nextInt(responseEntityMovie.getBody().getMovies().size() - 1);

        Map<String, ?> urlParametersRandomMoviePage = Map.of(
                "apiKey", apiKeyMovies,
                "genre", WeatherCondition.getGenreIdByConditionName(weather.getWeatherConditionShort()),
                "pageNo", randomPage);

        Movie randomMovie = rest.exchange(
                urlMovie,
                HttpMethod.GET,
                null,
                MoviePage.class,
                urlParametersRandomMoviePage)
                .getBody().getMovies().get(randomEntry);
        model.addAllAttributes(FieldMapper.toMap(randomMovie));

        return "result";
    }
}
