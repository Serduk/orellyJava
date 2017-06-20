package edu.mainRun.DataStructure.GenericClassExamples;

import edu.workClasses.animals.Animal;
import edu.workClasses.animals.Cat;
import edu.workClasses.animals.Dog;

import java.util.ArrayList;

/**
 * Generic example with List
 * Created by serdyuk on 6/20/17.
 */
public class TestGenericWithArrayList {
    public static void main(String[] args) {
        new TestGeneric1().go();
    }

    void go() {
        /*
        * 1. Create array with type "Animal", who take Cats and Dogs
        * 2. Create array with type "Dog", who take just Dog Object
        * */
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Dog());

        ArrayList<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        dogs.add(new Dog());
        /*
        * call Animals and Dogs
        * */
        takeAnimals(animals);
        takeAnimals(dogs);
    }

    /*
    * It's a key moment.
    * Method take Object Animal.
    * Animal take all extended from him classes, example: Dog
    * Key methods in "Animal" workable for all Classes
    * */
    void takeAnimals(ArrayList<? extends Animal> animals) {
        for (Animal a : animals) {
            a.eat();
        }
    }
}
