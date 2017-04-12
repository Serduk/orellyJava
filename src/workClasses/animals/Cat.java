package workClasses.animals;

/**
 * extends from Animal
 * Created by serdyuk on 4/12/17.
 */
public class Cat extends Animal {
    @Override
    public void eat() {
        super.eat();
        System.out.println("Cat");
    }

    @Override
    public void roam() {
        System.out.println("Cat Roam");
    }
}
