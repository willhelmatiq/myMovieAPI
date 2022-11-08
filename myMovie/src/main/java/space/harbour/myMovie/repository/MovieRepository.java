package space.harbour.myMovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import space.harbour.myMovie.entity.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>  {

    @Query("SELECT m FROM Movie m join m.genres g where g.genreId = :genreId")
    List<Movie> findAllByGenre(@Param("genreId") int genreId);

    Movie findByMovieId(int movieId);
}
