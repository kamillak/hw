package kz.aitu.project.repositories.interfaces;

import kz.aitu.project.entities.Review;
import kz.aitu.project.entities.Movie;

import java.util.List;

public interface IModRepository {
    boolean addMovie(Movie movie);
    List<Movie> getAllMovies();
    boolean removeMovie(int id);
    boolean editMovie(int id, String field, String[] values);
    boolean editMovieName(int id, String name);
    boolean editMovieYear(int id, int year);
    List<Review> getAllReviews();
    boolean deleteReview(int id);
    boolean promoteDemote(int id, boolean moderator);
}
