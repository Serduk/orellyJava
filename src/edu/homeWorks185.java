package edu;

import java.util.ArrayList;
import java.util.List;

/**
 * Home work from page 185
 * <p>
 * Created by serdyuk on 4/3/17.
 */
public class homeWorks185 {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();

        a.add(0, "zero");
        a.add(1, "one");
        a.add(2, "two");
        a.add(3, "three");
        printAll((ArrayList<String>) a);

        if (a.contains("three")) {
            a.add("four");
        }
        a.remove(2);
        printAll((ArrayList<String>) a);

        if (a.indexOf("four") != 4) {
            a.add(4, "4.2");
        }
        printAll((ArrayList<String>) a);

        if (a.contains("two")) {
            a.add("2.2");
        }
        printAll((ArrayList<String>) a);


    }


    private static void printAll(ArrayList<String> a1) {
        for (String element : a1) {
            System.out.print(element + " ");
        }
        System.out.println(" ");
    }
}