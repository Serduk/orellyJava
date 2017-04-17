package mainRun;

import workClasses.animals.AnimalList;
import workClasses.animals.Cat;
import workClasses.animals.Dog;

/**
 * test drive class for AnimalList Method
 * Created by serdyuk on 4/17/17.
 */
public class AnimalListTestDrive {
    public static void main(String[] args) {
        AnimalList animalLists = new AnimalList(5);
        Dog dog = new Dog();
        Cat cat = new Cat();

        animalLists.add(dog);
        animalLists.add(cat);
    }
}
