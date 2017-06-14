package edu.mainRun.DataStructure;

/**
 * Examples for work with toString
 * Created by serdyuk on 6/13/17.
 */
public class Song implements Comparable<Song> {
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

    /*
    * Method Sort() send Object Song in compareTo()
    * for see, how him correlates with exemplar Song,
    * from who called method
    * */
    @Override
    public int compareTo(Song o) {
        /*
        * Here all simple
        * We send all work to objects String
        * who give as variable TITLE,
        * because we know, String has method compareTo();
        * */
        return title.compareTo(o.getTitle());
    }
}
