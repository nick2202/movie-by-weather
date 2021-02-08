package de.hwr.moviebyweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    @JsonProperty("main")
    private String weatherConditionShort;

    @JsonProperty("description")
    private String weatherConditionLong;

    public Weather(String weatherConditionShort, String weatherConditionLong) {
        this.weatherConditionShort = weatherConditionShort;
        this.weatherConditionLong = weatherConditionLong;
    }
}
