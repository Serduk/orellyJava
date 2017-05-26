package edu.seriazableExample;

import java.io.*;

/**
 * Testing for save and upload serializable data
 * Created by serdyuk on 5/26/17.
 */
public class GameSaverTest {
    public static void main(String[] args) {
        String filePath = "resources/serializableData/game.ser";

//        Create 3 object for test
        GameCharacter one = new GameCharacter(13, "Human", new String[] {"Bow", "Arrows"});
        GameCharacter two = new GameCharacter(15, "Troll", new String[] {"Hands"});
        GameCharacter three = new GameCharacter(12, "Elve", new String[] {"Sword", "Spear", "Dagger"});

//        save all 3objects in .ser file
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filePath));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        set null for all 3objects, for tests
        one = null;
        two = null;
        three = null;

//        get all data from saved .ser file
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(filePath));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();

//            Check -> all data was uploaded
            System.out.println("First Type is: " + oneRestore.getType());
            System.out.println("Second Type is: " + twoRestore.getType());
            System.out.println("Third Type id: " + threeRestore.getType());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Not Founded Class");
        }
    }
}
