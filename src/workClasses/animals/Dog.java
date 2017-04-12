package workClasses.animals;

public class Dog extends Animal {
    public int size = 0;
    public String breed;
    public String name;

    @Override
    public void eat() {
        super.eat();
        System.out.println("Dog");
    }

    @Override
    public void roam() {
        System.out.println("Dog Roam");
    }

    public void bark() {
        System.out.println("gav");
    }
}