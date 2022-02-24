package kz.aitu.project;

import java.sql.*;

import kz.aitu.project.controllers.ModController;
import kz.aitu.project.data.interfaces.IDB;
import kz.aitu.project.data.DB;
import kz.aitu.project.entities.Movie;
import kz.aitu.project.entities.Review;
import kz.aitu.project.entities.User;
import kz.aitu.project.repositories.interfaces.IModRepository;
import kz.aitu.project.repositories.interfaces.IUserRepository;
import kz.aitu.project.repositories.ModRepository;
import kz.aitu.project.repositories.UserRepository;
import kz.aitu.project.controllers.UserController;

public class Main {
    public static void main(String[] args) {
        IDB db = new DB();

        //Moderator
        IModRepository modRepo = new ModRepository(db);
        ModController modControl = new ModController(modRepo);

//        modControl.deleteReview(0);

        //User
        IUserRepository userRepo = new UserRepository(db);
        UserController userControl = new UserController(userRepo);

//        userControl.addReview(1, 1, "Very good movie, I liked it!", 5);
//        userControl.addReview(1, 1, "That was ass!", 1);


        System.out.println(modControl.getAllUsers());
        System.out.println(modControl.getAllMovies());
        System.out.println(modControl.getAllReviews());
    }
}