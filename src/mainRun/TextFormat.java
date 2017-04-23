package mainRun;

/**
 * Class work: Text Formating for soup/console/terminal/etc output
 * Created by serdyuk on 4/23/17.
 */
public class TextFormat {
    public static void main(String[] args) {
        String s = String.format("%, d", 1000000);
        System.out.println(s);
        s = String.format("%,.2f", 200.45634);
        System.out.println(s);
        s = String.format("%x", 42);
        System.out.println(s);

        int one = 1234325;
        double two = 12235.214123;
        s = String.format("%,d and second number %,.2f", one, two);
        System.out.println(s);
    }
}