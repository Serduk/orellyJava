package edu.mainRun.DataStructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Examples for sorting in Lists
 * Created by serdyuk on 6/13/17.
 */
public class JukeBox1 {
    String pathToSongList = "";
    ArrayList songList = new ArrayList();

    public static void main(String[] args) {
        new JukeBox1().go();
    }

    public void go() {
        getSongs();
        System.out.println(songList);
        /*
        * Add Collection sort
        * for show how work sorting
        * Get static method Sort from class Collections
        * all elements sorted
        * */
        Collections.sort(songList);
        System.out.println(songList);
    }

    public void getSongs() {
        try {
            File file = new File(pathToSongList);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        songList.add(tokens[0]);
    }
}
