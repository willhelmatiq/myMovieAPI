package space.harbour.myMovie.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import space.harbour.myMovie.dto.AllGenresDto;
import space.harbour.myMovie.dto.PageOfMovieDto;

public interface TheMovieDbApi {

    @GET("3/movie/top_rated")
    Call<PageOfMovieDto> getMovies(@Query("api_key") String apiKey, @Query("page") int pageNumber);

    @GET("3/genre/movie/list")
    Call<AllGenresDto> getAllGenresDto(@Query("api_key") String apiKey);
}
