package de.hwr.moviebyweather.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "page",
        "results",
        "total_pages",
        "total_results"
})
@Getter
@Setter
public class MoviePage {

    @JsonProperty("page")
    private Integer page;
    @JsonProperty("results")
    private List<Movie> movies = null;
    @JsonProperty("total_pages")
    private Integer totalPages;
    @JsonProperty("total_results")
    private Integer totalResults;

    /**
     * No args constructor for use in serialization
     */
    public MoviePage() {
    }

    /**
     * @param totalResults
     * @param totalPages
     * @param page
     * @param movies
     */
    public MoviePage(Integer page, List<Movie> movies, Integer totalPages, Integer totalResults) {
        super();
        this.page = page;
        this.movies = movies;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
    }

}
