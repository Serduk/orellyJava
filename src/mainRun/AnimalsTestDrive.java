package mainRun;

import workClasses.animals.Animal;
import workClasses.animals.Cat;
import workClasses.animals.Dog;
import workClasses.animals.LittleDog;

/**
 * Test Drive for Animals Extends
 * Created by serdyuk on 4/12/17.
 */
public class AnimalsTestDrive {
    public static void main(String[] args) {
        Animal[] animal = new Animal[4];

        animal[0] = new Cat();
        animal[1] = new Dog();
        animal[2] = new LittleDog();

        animal[0].eat();
        animal[1].eat();
        animal[2].roam();

        go();
    }

    private static void go() {
        Dog aDog = new Dog();
        Object object = getObject(aDog);
        Dog object2 = (Dog) object;
        object2.roam();

        System.out.println("Dog has hashCode: " + aDog.hashCode());
        System.out.println("Object has hashCode: " + object.hashCode());
    }


    private static Object getObject(Object o) {
        return o;
    }
}
