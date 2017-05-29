package edu.mainRun.quizCardGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class example for Reading file
 * Created by serdyuk on 5/29/17.
 */
public class ReadFile {
    public static void main(String[] args) {
        try {
            File myFile = new File("MyText.txt");
//            FIleReader -> connection flow for simbols, which connected to text file
            FileReader fileReader = new FileReader(myFile);

//            for more effective reading, connect filereader with bufferedReader,
//            then file reader do connect to file only when buffer will be empty
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
