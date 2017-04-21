package workClasses.animals;

/**
 * extend Dog
 * Created by serdyuk on 4/12/17.
 */
public class LittleDog extends Dog implements HomeAnimalInterface {
    @Override
    public void roam() {
        super.roam();
        System.out.println("LittleDog roam");
    }

    @Override
    public void setName() {

    }

    @Override
    public String getName() {
        return null;
    }
}
