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
        SerializableExample example = new SerializableExample();
        example.setUp();

        try {
            FileOutputStream outputStream = new FileOutputStream("resources/serializableData/" + "foo.ser");
            ObjectOutputStream os = new ObjectOutputStream(outputStream);
            os.writeObject(example);
        } catch (Exception ex) {
            System.out.println("Exception in fileSaver");
        }
    }
}
