package space.harbour.myMovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import space.harbour.myMovie.entity.Movie;
import space.harbour.myMovie.service.MovieService;
import space.harbour.myMovie.service.PopulateDbService;

import java.util.List;

import static space.harbour.myMovie.util.Constants.MYMOVIEURL;

@RestController
@RequestMapping(MYMOVIEURL)
public class Controller {


    @Autowired
    MovieService movieService;

    @Autowired
    private PopulateDbService populateDbService;

    @GetMapping("/populateDb")
    public void populateDbByGenres() {
        populateDbService.populateDb();
    }

    @GetMapping("/movies")
    @ResponseBody
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movie/{id}")
    @ResponseBody
    public Movie getMovieById(@PathVariable("id") String movieId) {
        return movieService.getMovieById(Integer.parseInt(movieId));
    }

    @GetMapping("/moviesByGenre")
    @ResponseBody
    public List<Movie> getMoviesByGenre(@RequestParam String genreName) {
        return movieService.getMoviesByGenreName(genreName);
    }


    @GetMapping("/moviesByGenreWithLimit")
    @ResponseBody
    public List<Movie> getMoviesByGenreWithLimit(@RequestParam String genreName, @RequestParam int limit) {
        return movieService.getMoviesByGenreName(genreName, limit);
    }

    @GetMapping("/moviesAfterCertainYear/{year}")
    public List<Movie> getMoviesAfterCertainYear(@PathVariable String year){
        return movieService.getMoviesAfterCertainYear(Integer.parseInt(year));
    }

    @DeleteMapping("/movie/{id}")
    public void deleteMovieById(@PathVariable("id") String movieId) {
        movieService.deleteMovieById(Integer.parseInt(movieId));
    }


}
