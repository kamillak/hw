package kz.aitu.project.repositories.interfaces;

import kz.aitu.project.entities.Review;
import kz.aitu.project.entities.Movie;

import java.util.List;

public interface IModRepository {
    boolean addMovie(Movie movie);
    //    List<Movie> getAllMovies();
    boolean removeMovie(int id);
//    boolean editMovie(int id);
//    List<Review> getAllReviews();
//    boolean deleteReview(int id);
//    boolean promoteToMod(int id);
}
