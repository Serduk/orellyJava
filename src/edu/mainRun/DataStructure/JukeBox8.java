package edu.mainRun.DataStructure;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * Example for TreeSet
 * Created by serdyuk on 6/20/17.
 */
public class JukeBox8 {
    ArrayList<Song> songList = new ArrayList<Song>();
    int val;

    public static void main(String[] args) {
        new JukeBox8().go();
    }

    public void go() {
        getSong();
        System.out.println(songList);
        Collections.sort(songList);
        /*
        * Create Exemplar of TreeSet instead hashSet
        * Get constructor without arguments
        * means, for sort will be use standard method compareTo()
        * for each element
        * */
        TreeSet<Song> songSet = new TreeSet<Song>();
        /*
        * We Can add songs from HashSet through method addAll()
        * Also, we can add each song separately, just use songSet.add();
        * like we did it with ArrayList
        * */
        songSet.addAll(songList);

    }

    void getSong() {
        try {
            File file = new File("pathToMyFile");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addSong(String lineToParse) {
        String[] token = lineToParse.split("/");
        Song nextSong = new Song(token[0], token[1], token[2], token[3]);
        songList.add(nextSong);
    }
}
