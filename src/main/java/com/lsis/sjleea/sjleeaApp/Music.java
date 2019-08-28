package com.lsis.sjleea.sjleeaApp;

import javax.persistence.*;

@Entity
@Table(name = "music")
public class Music {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String album;
    private String genre;
    private int year;
    private int rating;

    public Music()
    {

    }

    public Music(String title, String album, String genre, int year, int rating) {
        this.id = id;
        this.title = title;
        this.album = album;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
