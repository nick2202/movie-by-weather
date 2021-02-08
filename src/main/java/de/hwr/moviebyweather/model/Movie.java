package de.hwr.moviebyweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "adult",
        "backdrop_path",
        "genre_ids",
        "id",
        "original_language",
        "original_title",
        "overview",
        "popularity",
        "poster_path",
        "release_date",
        "title",
        "video",
        "vote_average",
        "vote_count"
})
@Getter
@Setter
public class Movie {

    @JsonProperty("adult")
    private Boolean adult;
    @JsonProperty("backdrop_path")
    private String backdropPath;
    @JsonProperty("genre_ids")
    private List<Integer> genreIds = null;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("original_title")
    private String originalTitle;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("popularity")
    private Double popularity;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("title")
    private String title;
    @JsonProperty("video")
    private Boolean video;
    @JsonProperty("vote_average")
    private Double voteAverage;
    @JsonProperty("vote_count")
    private Integer voteCount;

    /**
     * No args constructor for use in serialization
     *
     */
    public Movie() {
    }

    /**
     *
     * @param overview
     * @param voteAverage
     * @param releaseDate
     * @param video
     * @param genreIds
     * @param originalLanguage
     * @param title
     * @param originalTitle
     * @param popularity
     * @param backdropPath
     * @param id
     * @param voteCount
     * @param adult
     * @param posterPath
     */
    public Movie(Boolean adult, String backdropPath, List<Integer> genreIds, Integer id, String originalLanguage, String originalTitle, String overview, Double popularity, String posterPath, String releaseDate, String title, Boolean video, Double voteAverage, Integer voteCount) {
        super();
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.genreIds = genreIds;
        this.id = id;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

}
