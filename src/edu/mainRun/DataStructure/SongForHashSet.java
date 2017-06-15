package edu.mainRun.DataStructure;

import java.util.Comparator;

/**
 * This class created for HashSet example
 * Here will be override hashCode() and equals() methods
 * Created by serdyuk on 6/15/17.
 */
public class SongForHashSet implements Comparable<SongForHashSet> {
    String title;
    String artist;
    String rating;
    String bpm;

    public SongForHashSet(String title, String artist, String rating, String bpm) {
        this.title = title;
        this.artist = artist;
        this.rating = rating;
        this.bpm = bpm;
    }

    /*
    * Hash set use this method (or anybody another)
    * method send here another object Song
    * */
    public boolean equals(Object aSong) {
        SongForHashSet s = (SongForHashSet) aSong;
        /*
        * Good news in next:
        * title => it's a String
        * and String has method equals();
        * We need ask in variable Title =>
        * equal his title with title from income object aSong;
        * */
        return getTitle().equals(s.getTitle());
    }

    /*
    * Here the same as upper
    * */
    public int hashCode(Object aSong) {
        SongForHashSet s = (SongForHashSet) aSong;
        return title.hashCode();

    }


    @Override
    public int compareTo(SongForHashSet o) {
        return 0;
    }

    public String getTitle() {
        return title;
    }
}
