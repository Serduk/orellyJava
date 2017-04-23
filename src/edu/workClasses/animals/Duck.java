package edu.workClasses.animals;

/**
 * Constructor for Duck
 * Created by serdyuk on 4/21/17.
 */
public class Duck extends Animal {
    int size;
    public Duck (int size) {
        System.out.println("I'm Created");
        this.size = size;
        System.out.println("Duck size is " + this.size);

    }

    public Duck() {
        System.out.println("OverLoaded Constructor");
    }

    @Override
    public void roam() {
        System.out.println("Roam");
    }
}
