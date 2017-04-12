package workClasses.animals;

/**
 * Main class for Animals
 * Created by serdyuk on 4/12/17.
 */
public abstract class Animal {
    protected int size, wait, height;

    public void eat() {
        System.out.println("eat");
    }

    public abstract void roam();
}
