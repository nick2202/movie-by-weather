package de.hwr.moviebyweather.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City {

    private Integer zipCode;
    private String countryCode;
    private String name;
}
