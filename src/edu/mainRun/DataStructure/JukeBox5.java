package edu.mainRun.DataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Add Comparator to inner classes
 * Add few types of sorting
 * Created by serdyuk on 6/14/17.
 */
public class JukeBox5 {
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        new JukeBox5().go();
    }

    /*
    * Creating new inner class
    * who implement Comparator, with object Song
    * */
    class ArtistCompare implements Comparator<Song> {
        @Override
        /*
        * String class compare all data from object Song,
        * and sort all by Artist
        * */
        public int compare(Song o1, Song o2) {
            return o1.getArtist().compareTo(o2.getArtist());
        }
    }

    public void go() {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);

        ArtistCompare artistCompare = new ArtistCompare();
        Collections.sort(songList, artistCompare);
        System.out.println(songList);
    }

    void getSongs() {

    }

    void addSong() {

    }
}
