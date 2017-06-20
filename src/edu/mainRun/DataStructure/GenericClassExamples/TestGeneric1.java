package edu.mainRun.DataStructure.GenericClassExamples;

import edu.workClasses.animals.Animal;
import edu.workClasses.animals.Cat;
import edu.workClasses.animals.Dog;

/**
 * Generic Example
 * Created by serdyuk on 6/20/17.
 */
public class TestGeneric1 {
    public static void main(String[] args) {
        new TestGeneric1().go();
    }

    void go() {
        /*
        * 1. Create array with type "Animal", who take Cats and Dogs
        * 2. Create array with type "Dog", who take just Dog Object
        * */
        Animal[] animals = {new Dog(), new Cat(), new Dog()};
        Dog[] dogs = {new Dog(), new Dog(), new Dog()};
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
    void takeAnimals(Animal[] animals) {
        for (Animal a : animals) {
            a.eat();
        }
    }
}
