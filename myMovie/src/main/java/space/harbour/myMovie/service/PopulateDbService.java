package space.harbour.myMovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.harbour.myMovie.dto.AllGenresDto;
import space.harbour.myMovie.dto.PageOfMovieDto;
import space.harbour.myMovie.entity.Genre;
import space.harbour.myMovie.entity.Movie;
import space.harbour.myMovie.repository.GenreRepository;
import space.harbour.myMovie.repository.MovieRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static space.harbour.myMovie.convertor.DtoToEntityConverter.toNewGenre;
import static space.harbour.myMovie.convertor.DtoToEntityConverter.toNewMovie;
import static space.harbour.myMovie.util.Constants.API_KEY;
import static space.harbour.myMovie.util.Constants.PAGENUMBER;

@Service
public class PopulateDbService {

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheMovieDbService theMovieDbService;

    public void populateDb() {
        populateDbByGenres();
        populateDbByMovies();
    }

    public void populateDbByGenres() {
        AllGenresDto allGenresDto = theMovieDbService.getAllGenresDto(API_KEY);
        List<Genre> genreList = new ArrayList<>();
        Arrays.stream(allGenresDto.getGenres()).forEach(genresDto -> {
            genreList.add(toNewGenre(genresDto));
        });
        genreRepository.saveAll(genreList);
    }

    public void populateDbByMovies() {
        List<Movie> movieList = new ArrayList<>();
        PageOfMovieDto pageOfMovieDto;
        for (int i = 1; i <= PAGENUMBER; i++) {
            pageOfMovieDto = theMovieDbService.getMovies(API_KEY, i);
            Arrays.stream(pageOfMovieDto.getResults()).forEach(movieDto -> {
                Movie movie = toNewMovie(movieDto);
                List<Genre> genreList = new ArrayList<>();
                Arrays.stream(movieDto.getGenre_ids()).forEach(id -> {
                    genreList.add(genreRepository.findByGenreId(id));
                });
                movie.setGenres(genreList);
                movieList.add(movie);
            });
        }
        movieRepository.saveAll(movieList);

    }
}
