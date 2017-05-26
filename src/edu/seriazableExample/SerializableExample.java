package edu.seriazableExample;

import edu.workClasses.animals.Dog;

import java.io.*;

/**
 * example for Serializable
 * Created by serdyuk on 5/25/17.
 */
public class SerializableExample implements Serializable {
    Dog dog = new Dog();


    public void setUp() {
        dog.bark();
        dog.eat();
        dog.name = "johny";
    }


    public static void main(String[] args) {
        String filePath = "resources/serializableData/";
        String fileName = "foo.ser";

        SerializableExample example = new SerializableExample();
        example.setUp();

        try {
            FileOutputStream outputStream = new FileOutputStream(filePath + fileName);
            ObjectOutputStream os = new ObjectOutputStream(outputStream);
            os.writeObject(example);
        } catch (Exception ex) {
            System.out.println("Exception in fileSaver");
        }

        try {
            FileInputStream inputStream = new FileInputStream(filePath+fileName);
            ObjectInputStream os = new ObjectInputStream(inputStream);
//            System.out.println(os.available());

            Object one = os.readObject();
//            Object two = os.readObject();

            Dog dog = (Dog) one;
            dog.bark();
            os.close();
        } catch (Exception e) {
            System.out.println("Problem with Reading Serializable file");
        }
    }
}
