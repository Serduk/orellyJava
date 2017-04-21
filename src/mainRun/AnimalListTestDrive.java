package mainRun;

import workClasses.animals.*;

/**
 * test drive class for AnimalList Method
 * Created by serdyuk on 4/17/17.
 */
public class AnimalListTestDrive {
    public static void main(String[] args) {
        AnimalList animalLists = new AnimalList(5);
        Dog dog = new Dog();
        Cat cat = new Cat();
        Duck duck = new Duck(13);
        Duck duck1 = new Duck();
        SuperDuck superDuck = new SuperDuck(13);

        animalLists.add(dog);
        animalLists.add(cat);
    }
}
