package de.hwr.moviebyweather.model;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum WeatherCondition {

    THUNDERSTORM("Thunderstorm", Genre.ADVENTURE),
    DRIZZLE("Drizzle", Genre.ADVENTURE),
    RAIN("Rain", Genre.ADVENTURE),
    SNOW("Snow", Genre.ADVENTURE),
    ATMOSPHERE("Atmosphere", Genre.ADVENTURE),
    CLEAR("Clear", Genre.ADVENTURE),
    CLOUDS("Clouds", Genre.ACTION);

    private final String conditionName;
    private final Genre genre;

    WeatherCondition(final String conditionName, final Genre genre) {
        this.conditionName = conditionName;
        this.genre = genre;
    }

    public static int getGenreIdByConditionName(String conditionName) {
        return Arrays.stream(values())
                .filter(wc -> wc.getConditionName().equals(conditionName))
                .findFirst()
                .orElseThrow()
                .getGenre()
                .getId();
    }
}
