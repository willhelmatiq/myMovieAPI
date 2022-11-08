package space.harbour.myMovie.convertor;

import space.harbour.myMovie.dto.GenresDto;
import space.harbour.myMovie.dto.MovieDto;
import space.harbour.myMovie.entity.Genre;
import space.harbour.myMovie.entity.Movie;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DtoToEntityConverter {

    public static Genre toNewGenre(GenresDto genresDto) {
        Genre genre = new Genre();
        genre.setGenreId(genresDto.getId());
        genre.setGenreName(genresDto.getName());
        return genre;
    }

    public static Movie toNewMovie(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setAdult(movieDto.isAdult());
        movie.setMovieId(movieDto.getId());
        movie.setOriginalLanguage(movieDto.getOriginal_language());
        movie.setOriginalTitle(movieDto.getOriginal_title());
        movie.setOverview(movieDto.getOverview());
        movie.setPopularity(movieDto.getPopularity());
        movie.setReleaseDate(LocalDate.parse(movieDto.getRelease_date(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        movie.setTitle(movieDto.getTitle());
        movie.setVoteAverage(movieDto.getVote_average());
        movie.setVoteCount(movieDto.getVote_count());
        return movie;
    }
}
