package workClasses.animals;

/**
 * Create animal list
 * Created by serdyuk on 4/17/17.
 */
public class AnimalList {
    public AnimalList(int size) {
        animals = new Animal[size];
    }
    private Animal[] animals;
    private int nextIndex = 0;

    public void add(Animal animal) {
        if (nextIndex < animals.length) {
            animals[nextIndex] = animal;
            System.out.println("Animal was added in index " + nextIndex);
            nextIndex++;
        }
    }
}
