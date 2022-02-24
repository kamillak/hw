package kz.aitu.project.entities;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Movie {
    private int id;
    private String name;
    private String[] genre;
    private String[] country;
    private int year;
    private String[] director;
    private String[] writers;
    private String[] cast;
    private double rating;

    public Movie() {

    }

    public Movie(String name, String[] genre, String[] country, int year, String[] director, String[] writers, String[] cast){
        setName(name);
        setGenre(genre);
        setCountry(country);
        setYear(year);
        setDirector(director);
        setWriters(writers);
        setCast(cast);
    }

    public Movie(String name, String[] genre, String[] country, int year, String[] director, String[] writers, String[] cast,
                 double rating) {
        setName(name);
        setGenre(genre);
        setCountry(country);
        setYear(year);
        setDirector(director);
        setWriters(writers);
        setCast(cast);
        setRating(rating);
    }

    public Movie(int id, String name, String[] genre, String[] country, int year, String[] director, String[] writers,
                 String[] cast, double rating) {
        setId(id);
        setName(name);
        setGenre(genre);
        setCountry(country);
        setYear(year);
        setDirector(director);
        setWriters(writers);
        setCast(cast);
        setRating(rating);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setCountry(String[] country) {
        this.country = country;
    }

    public String[] getCountry() {
        return country;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setDirector(String[] director) {
        this.director = director;
    }

    public String[] getDirector() {
        return director;
    }

    public void setWriters(String[] writers) {
        this.writers = writers;
    }

    public String[] getWriters() {
        return writers;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public String[] getCast() {
        return cast;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre=" + Arrays.toString(genre) +
                ", country=" + Arrays.toString(country) +
                ", year=" + year +
                ", director=" + Arrays.toString(director) +
                ", writers=" + Arrays.toString(writers) +
                ", cast=" + Arrays.toString(cast) +
                ", rating=" + rating +
                '}' + '\n';
    }
}
