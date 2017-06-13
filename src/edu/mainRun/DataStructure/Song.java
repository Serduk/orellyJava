package edu.mainRun.DataStructure;

/**
 * Examples for work with toString
 * Created by serdyuk on 6/13/17.
 */
public class Song {
    String title;
    String artist;
    String rating;
    String bpm;

    Song(String title, String artist, String rating, String bpm) {
        this.title = title;
        this.artist = artist;
        this.rating = rating;
        this.bpm = bpm;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getRating() {
        return artist;
    }

    public String getBpm() {
        return bpm;
    }

    public String getTitle(int i) {
        return title.toString();
    }
}
