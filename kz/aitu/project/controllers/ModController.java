package kz.aitu.project.controllers;

import kz.aitu.project.entities.Movie;
import kz.aitu.project.entities.Review;
import kz.aitu.project.entities.User;
import kz.aitu.project.repositories.interfaces.IModRepository;

import java.util.List;

public class ModController {
    private IModRepository repo;

    public ModController(IModRepository repo) {
        this.repo = repo;
    }

    public String addMovie(String name, String[] genre, String[] country, int year, String[] director, String[] writers,
                           String[] cast) {
        Movie movie = new Movie(name, genre, country, year, director, writers, cast);

        boolean added = repo.addMovie(movie);

        if (added == true) {
            return "Movie has been added";
        } else {
            return "The process have failed!";
        }
    }

    public String getAllMovies() {
        List<Movie> movies = repo.getAllMovies();

        return movies.toString();
    }

    public String getAllUsers() {
        List<User> users = repo.getAllUsers();

        return users.toString();
    }

    public String removeMovie(int id) {
        boolean removed = repo.removeMovie(id);

        if (removed == true) {
            return "Movie has been removed";
        } else {
            return "The process have failed";
        }
    }

    public String editMovie(int id, String field, String[] values) {
        boolean edited = repo.editMovie(id, field, values);

        if (edited==true) {
            return "Movie has been updated";
        } else {
            return "The process have failed";
        }
    }

    public String editMovieName(int id, String name) {
        boolean edited = repo.editMovieName(id, name);

        if (edited==true) {
            return "Movie has been updated";
        } else {
            return "The process have failed";
        }
    }

    public String editMovieYear(int id, int year) {
        boolean edited = repo.editMovieYear(id, year);

        if (edited==true) {
            return "Movie has been updated";
        } else {
            return "The process have failed";
        }
    }

    public String getAllReviews() {
        List<Review> reviews = repo.getAllReviews();

        return reviews.toString();
    }
}
