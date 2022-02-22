package kz.aitu.project.entities;

public class Movie {
    private int id;
    private String name;
    private String genre;
    private String country;
    private int year;
    private String director;
    private String writers;
    private String cast;
    private int rating;

    public Movie() {

    }

    public Movie(String name, String genre, String country, int year, String director, String writers, String cast, int rating) {
        setName(name);
        setGenre(genre);
        setCountry(country);
        setYear(year);
        setDirector(director);
        setWriters(writers);
        setCast(cast);
        setRating(rating);
    }

    public Movie(int id, String name, String genre, String country, int year, String director, String writers, String cast, int rating) {
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

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setWriters(String writers) {
        this.writers = writers;
    }

    public String getWriters() {
        return writers;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getCast() {
        return cast;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}

public class Account
{
    protected int id;
    public String name;
    private String film;

    public Account(int id,String name, String Film)
    {
        this.id = id;
        this.name = name;
        this.film = film;

    }

    public Account(){
        this.id = 0;
        this.name = null;
        this.film = null;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setFilm(String film){
        this.film = film;
    }
    public String getFilm(){
        return this.film;
    }
}