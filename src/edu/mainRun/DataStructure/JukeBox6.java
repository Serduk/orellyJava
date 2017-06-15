package edu.mainRun.DataStructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Examples with hashSet
 * How it work and etc
 * Created by serdyuk on 6/15/17.
 */
public class JukeBox6 {
    ArrayList<Song> songList = new ArrayList<Song>();

    String pathToFile = "";

    public void go() {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);

        /*
        * Here we create new HashSet (mnojestvo)
        * who created for saving object Song
        * */
        HashSet<Song> songSet = new HashSet<Song>();
        /*
        * addAll() -> simple method who get another collection
        * and use it for filling himself (HashSet)
        * Result same if we will added each song per one
        * But more easier
        * */
        songSet.addAll(songList);
        System.out.println(songSet);
    }

    public void getSongs() {
        try {
            File file = new File(pathToFile);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addSong(String line) {

    }
}
