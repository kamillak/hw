package kz.aitu.project.entities;

public class Review {
    private int id;
    private int movieid;
    private int userid;
    private String review;
    private int rating;

    public Review() {

    }

    public Review(int movieid, int userid, String review, int rating) {
        setMovieid(movieid);
        setUserid(userid);
        setReview(review);
        setRating(rating);
    }

    public Review(int id, int movieid, int userid, String review, int rating) {
        setId(id);
        setMovieid(movieid);
        setUserid(userid);
        setReview(review);
        setRating(rating);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getUserid() {
        return userid;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getReview() {
        return review;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}
