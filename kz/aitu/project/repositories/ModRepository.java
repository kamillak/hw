package kz.aitu.project.repositories;

import kz.aitu.project.data.interfaces.IDB;
import kz.aitu.project.entities.*;
import kz.aitu.project.repositories.interfaces.IModRepository;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ModRepository implements IModRepository {
    private final IDB db;

    public ModRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean addMovie(Movie movie) {
        Connection con = null;
        try {
            con = db.getConnection();
            Array arrayGenre = con.createArrayOf("text", movie.getGenre());
            Array arrayCountry = con.createArrayOf("text", movie.getCountry());
            Array arrayDirector = con.createArrayOf("text", movie.getDirector());
            Array arrayWriters = con.createArrayOf("text", movie.getWriters());
            Array arrayCast = con.createArrayOf("text", movie.getCast());
            String sql = "INSERT INTO movies(name, genre, country, year, director, writers, actors, rating) VALUES(?, ?, ?, ?, ?, ?, ?, 0)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, movie.getName());
            st.setArray(2, arrayGenre);
            st.setArray(3, arrayCountry);
            st.setInt(4, movie.getYear());
            st.setArray(5, arrayDirector);
            st.setArray(6, arrayWriters);
            st.setArray(7, arrayCast);

            boolean executed = st.execute();
            return executed;
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
        return false;
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
                Movie movie = new Movie(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getArray("genre"),
                        rs.getArray("country"),
                        rs.getInt("year"),
                        rs.getArray("director"),
                        rs.getArray("writers"),
                        rs.getArray("actors"),
                        rs.getInt("rating"));
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
    public boolean removeMovie(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM movies WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
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
        return false;
    }

//    @Override
//    public boolean editMovie(int id) {
//        Connection con = null;
//        try {
//            con = db.getConnection();
//            String sql = "UPDATE movies SET name=? AND "
//        }
//    }


}
