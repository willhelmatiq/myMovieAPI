package space.harbour.myMovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.harbour.myMovie.entity.Genre;
import space.harbour.myMovie.entity.Movie;
import space.harbour.myMovie.repository.GenreRepository;
import space.harbour.myMovie.repository.MovieRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    GenreRepository genreRepository;


    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(int movieId) {
        return movieRepository.findByMovieId(movieId);
    }

    @Override
    public List<Movie> getMoviesAfterCertainYear(int year) {
        return movieRepository.findAll().stream().filter(movie -> {
            if (movie.getReleaseDate().isAfter(LocalDate.of(year,1,1))){
                return true;
            }
            return false;
        }).toList();
    }

    @Override
    public void deleteMovieById(int movieId) {
        Movie movie = movieRepository.findByMovieId(movieId);
        movieRepository.delete(movie);
    }

    @Override
    public List<Movie> getMoviesByGenreName(String genreName) {
        Genre genre = genreRepository.findByGenreName(genreName);
        return movieRepository.findAllByGenre(genre.getGenreId());
    }

    @Override
    public List<Movie> getMoviesByGenreName(String genreName, int limit) {
        Genre genre = genreRepository.findByGenreName(genreName);
        return movieRepository.findAllByGenre(genre.getGenreId()).stream().limit((long)limit).toList();
    }

   }
