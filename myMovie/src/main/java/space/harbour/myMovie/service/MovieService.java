package space.harbour.myMovie.service;

import space.harbour.myMovie.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getMoviesByGenreName(String genreName);
    List<Movie> getMoviesByGenreName(String genreName, int limit);

    List<Movie> getAllMovies();

    Movie getMovieById(int movieId);

    List<Movie> getMoviesAfterCertainYear(int year);

    void deleteMovieById(int movieId);
}
