package space.harbour.myMovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import space.harbour.myMovie.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    Genre findByGenreId(int genreId);

    Genre findByGenreName(String genreName);
}
