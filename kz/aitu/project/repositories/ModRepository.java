package kz.aitu.project.repositories;

import kz.aitu.project.data.interfaces.IDB;
import kz.aitu.project.entities.Movie;
import kz.aitu.project.entities.User;
import kz.aitu.project.entities.Review;
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
    public List<User> getAllUsers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM users";
            PreparedStatement st = con.prepareStatement(sql);

            List<User> users = new LinkedList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("recovery_question"),
                        rs.getString("question_answer"),
                        rs.getBoolean("moderator"));
                users.add(user);
            }
            return users;
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

    @Override
    public boolean editMovie(int id, String field, String[] values) {
        Connection con = null;
        try {
            con = db.getConnection();
            if (field=="genre") {
                Array arrayGenre = con.createArrayOf("text", values);

                String sql = "UPDATE movies SET genre=? WHERE id=?";
                PreparedStatement st = con.prepareStatement(sql);

                st.setArray(1, arrayGenre);

                ResultSet rs = st.executeQuery();
            } else if (field=="country") {
                Array arrayCountry = con.createArrayOf("text", values);

                String sql = "UPDATE movies SET country=? WHERE id=?";
                PreparedStatement st = con.prepareStatement(sql);

                st.setArray(1, arrayCountry);

                ResultSet rs = st.executeQuery();
            } else if (field=="director") {
                Array arrayDirector = con.createArrayOf("text", values);

                String sql = "UPDATE movies SET director=? WHERE id=?";
                PreparedStatement st = con.prepareStatement(sql);

                st.setArray(1, arrayDirector);

                ResultSet rs = st.executeQuery();
            } else if (field=="writers") {
                Array arrayWriters = con.createArrayOf("text", values);

                String sql = "UPDATE movies SET writers=? WHERE id=?";
                PreparedStatement st = con.prepareStatement(sql);

                st.setArray(1, arrayWriters);

                ResultSet rs = st.executeQuery();
            } else if (field=="cast") {
                Array arrayCast = con.createArrayOf("text", values);

                String sql = "UPDATE movies SET actors=? WHERE id=?";
                PreparedStatement st = con.prepareStatement(sql);

                st.setArray(1, arrayCast);

                ResultSet rs = st.executeQuery();
            }
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
    public boolean editMovieName(int id, String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE movies SET name=? WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, name);

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

    @Override
    public boolean editMovieYear(int id, int year) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE movies SET year=? WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, year);

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

    @Override
    public List<Review> getAllReviews() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM reviews";
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            List<Review> reviews = new LinkedList<>();
            while (rs.next()) {
                Review review = new Review(rs.getInt("id"),
                        rs.getInt("movieid"),
                        rs.getInt("userid"),
                        rs.getString("review"),
                        rs.getDouble("rating"));
                reviews.add(review);
            }
            return reviews;
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
    public boolean deleteReview(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM reviews WHERE id=?";
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

    @Override
    public boolean promoteDemote(int id, boolean moderator) {
        Connection con = null;
        List<User> users = getAllUsers();
        try {
            if(users.get(id).isModerator() == false) {
                con = db.getConnection();
                String sql = "UPDATE users SET moderator=true WHERE id=?";
                PreparedStatement st = con.prepareStatement(sql);

                st.setInt(1, id);

                ResultSet rs = st.executeQuery();
            } else {
                con = db.getConnection();
                String sql = "UPDATE users SET moderator=false WHERE id=?";
                PreparedStatement st = con.prepareStatement(sql);

                st.setInt(1, id);

                ResultSet rs = st.executeQuery();
            }
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
}
