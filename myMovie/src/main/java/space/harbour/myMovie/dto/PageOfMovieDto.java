package space.harbour.myMovie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageOfMovieDto {

    private int page;
    private MovieDto[] results;
}
