package kz.aitu.project.repositories;

import kz.aitu.project.data.interfaces.IDB;
import kz.aitu.project.entities.Movie;
import kz.aitu.project.entities.Review;
import kz.aitu.project.repositories.interfaces.IUserRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private final IDB db;

    public UserRepository(IDB db) {
        this.db = db;
    }

    @Override
    public List<Movie> getAllMovies() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, genre, country, year, director, writers, actors, rating FROM movies";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Movie> movies = new LinkedList<>();
            while (rs.next()) {
                Array arrayGenre = rs.getArray("genre");
                String[] genre = (String[])arrayGenre.getArray();
                Array arrayCountry = rs.getArray("country");
                String[] country = (String[])arrayCountry.getArray();
                Array arrayDirector = rs.getArray("director");
                String[] director = (String[])arrayDirector.getArray();
                Array arrayWriters = rs.getArray("writers");
                String[] writers = (String[])arrayWriters.getArray();
                Array arrayCast = rs.getArray("actors");
                String[] cast = (String[])arrayCast.getArray();
                Movie movie = new Movie(rs.getInt("id"),
                        rs.getString("name"),
                        genre,
                        country,
                        rs.getInt("year"),
                        director,
                        writers,
                        cast,
                        rs.getDouble("rating"));
                movies.add(movie);
            }
            return movies;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Movie> orderMovies(String type) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, genre, country, year, director, writers, actors, rating FROM movies ORDER BY " + type + " ASC";
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            List<Movie> movies = new LinkedList<>();
            while (rs.next()) {
                Array arrayGenre = rs.getArray("genre");
                String[] genre = (String[])arrayGenre.getArray();
                Array arrayCountry = rs.getArray("country");
                String[] country = (String[])arrayCountry.getArray();
                Array arrayDirector = rs.getArray("director");
                String[] director = (String[])arrayDirector.getArray();
                Array arrayWriters = rs.getArray("writers");
                String[] writers = (String[])arrayWriters.getArray();
                Array arrayCast = rs.getArray("actors");
                String[] cast = (String[])arrayCast.getArray();
                Movie movie = new Movie(rs.getInt("id"),
                        rs.getString("name"),
                        genre,
                        country,
                        rs.getInt("year"),
                        director,
                        writers,
                        cast,
                        rs.getDouble("rating"));
                movies.add(movie);
            }
            return movies;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean addReview(Review review) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO reviews(movieid, userid, review, rating) VALUES(?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, review.getMovieid());
            st.setInt(2, review.getUserid());
            st.setString(3, review.getReview());
            st.setDouble(4, review.getRating());

            boolean executed = st.execute();
            return executed;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public double averageRating(int movieid) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT rating FROM reviews WHERE movieid=?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, movieid);

            ResultSet rs = st.executeQuery(sql);

            double average_rating = 0;
            int rating_count = 0;

            while (rs.next()) {
                average_rating += rs.getInt("rating");
                rating_count++;
            }
            return (average_rating / rating_count);

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public List<String> browseMovie(String type) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT name FROM movies WHERE " + type + "=?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, type);

            ResultSet rs = st.executeQuery(sql);
            List<String> movies = new LinkedList<>();
            while (rs.next()) {
                String movie = rs.getString("name");
                movies.add(movie);
            }
            return movies;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

}