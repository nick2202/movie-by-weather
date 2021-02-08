package de.hwr.moviebyweather.model;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum WeatherCondition {

    THUNDERSTORM("Thunderstorm", Genre.ADVENTURE),
    DRIZZLE("Drizzle", Genre.THRILLER),
    RAIN("Rain", Genre.DOCUMENTARY),
    SNOW("Snow", Genre.ROMANCE),
    ATMOSPHERE("Atmosphere", Genre.DOCUMENTARY),
    CLEAR("Clear", Genre.ACTION),
    CLOUDS("Clouds", Genre.COMEDY);

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
