package kz.aitu.project.repositories.interfaces;

import kz.aitu.project.entities.Movie;
import kz.aitu.project.entities.Review;

import java.util.List;

public interface IUserRepository {
    List<Movie> getAllMovies();
    
    List<Movie> orderMovies(String type);

    List<String> browseMovie(String type);

    boolean addReview(Review review);
    double averageRating(int movieid);

}
