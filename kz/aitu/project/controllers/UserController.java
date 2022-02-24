package kz.aitu.project.controllers;

import kz.aitu.project.entities.Movie;
import kz.aitu.project.entities.Review;
import kz.aitu.project.repositories.interfaces.IUserRepository;

import java.util.List;

public class UserController {
    private IUserRepository repo;

    public UserController(IUserRepository repo) {
        this.repo = repo;
    }

    public String addReview(int movieid, int userid, String review, int rating) {
        Review review_ = new Review(movieid, userid, review, rating);

        boolean added = repo.addReview(review_);

        if (added == true) {
            return "Review has been added";
        } else {
            return "The process have failed!";
        }
    }

    public String averageRating(int movieid){
        double rate = repo.averageRating(movieid);

        if (rate != 0){
            return "The movie's rating is " + rate;
        }
        else {
            return "This movie is not rated!";
        }
    }

    public String getAllMovies() {
        List<Movie> movies = repo.getAllMovies();

        return movies.toString();
    }

    public String orderMovies(String type){
        List<Movie> movies = repo.orderMovies(type);

        return movies.toString();
    }

    public String browseMovie(String type){
        List<String> movies = repo.browseMovie(type);

        return movies.toString();
    }
}