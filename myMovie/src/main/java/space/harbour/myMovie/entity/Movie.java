package space.harbour.myMovie.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "adult")
    private boolean adult;

    @ManyToMany
    private List<Genre> genres;

    @Column(name = "movieId")
    private int movieId;

    @Column(name = "originalLanguage")
    private String originalLanguage;

    @Column(name = "originalTitle")
    private String originalTitle;

    @Column(name = "overview", columnDefinition = "text")
    private String overview;

    @Column(name = "popularity")
    private double popularity;

    @Column(name = "releaseDate")
    private LocalDate releaseDate;

    @Column(name = "title")
    private String title;

    @Column(name = "voteAverage")
    private double voteAverage;

    @Column(name = "voteCount")
    private int voteCount;

}
