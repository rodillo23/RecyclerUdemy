package com.example.joserodolfofigueroachavez.recyclerudemy.model;

public class Movie {

    private String movieName;
    private int moviePoster;

    public Movie(String movieName, int moviePoster) {
        this.movieName = movieName;
        this.moviePoster = moviePoster;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(int moviePoster) {
        this.moviePoster = moviePoster;
    }
}
