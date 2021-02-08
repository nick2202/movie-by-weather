package de.hwr.moviebyweather.model;

import lombok.Getter;

@Getter
public enum Genre {

    ACTION("Action", 28),
    ADVENTURE("Adventure", 12),
    ANIMATION("Animation", 16),
    COMEDY("Comedy", 35),
    CRIME("Crime", 80);




    private final String name;
    private final Integer id;

    Genre(String name, Integer id) {
        this.name = name;
        this.id = id;
    }
}
