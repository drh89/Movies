package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name = "Movies.deleteAllRows", query = "DELETE FROM Movie"),
@NamedQuery(name = "Movies.all", query = "SELECT m FROM Movie m"),
@NamedQuery(name = "Movies.getMovieByName", query = "SELECT m FROM Movie m WHERE m.movieName LIKE :name")
})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String movieName;
    private String movieType;
    private double movieLength;
    private double imdbScore;

    public Movie(Long id, String movieName, String movieType, double movieLength, double imdbScore) {
        this.id = id;
        this.movieName = movieName;
        this.movieType = movieType;
        this.movieLength = movieLength;
        this.imdbScore = imdbScore;
    }

    public Movie() {
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public double getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(double movieLength) {
        this.movieLength = movieLength;
    }

    public double getImdbScore() {
        return imdbScore;
    }

    public void setImdbScore(double imdbScore) {
        this.imdbScore = imdbScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
