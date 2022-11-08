package space.harbour.myMovie.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import space.harbour.myMovie.dto.AllGenresDto;
import space.harbour.myMovie.util.Constants;
import space.harbour.myMovie.dto.PageOfMovieDto;

import java.io.IOException;

@Service
public class TheMovieDbService {

    private TheMovieDbApi api;

    public TheMovieDbService() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        api = retrofit.create(TheMovieDbApi.class);
    }
    public PageOfMovieDto getMovies(String apiKey, int pageNumber) {
        Call<PageOfMovieDto>  moviesCall = api.getMovies(apiKey, pageNumber);
        try {
            Response<PageOfMovieDto> response = moviesCall.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public AllGenresDto getAllGenresDto(String apiKey) {
        Call<AllGenresDto>  allGenresDtoCall = api.getAllGenresDto(apiKey);
        try {
            Response<AllGenresDto> response = allGenresDtoCall.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
