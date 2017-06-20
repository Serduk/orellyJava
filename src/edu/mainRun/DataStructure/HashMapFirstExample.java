package edu.mainRun.DataStructure;

import java.util.HashMap;

/**
 * Here will be example for HashMap,
 * How work it, and etc
 * Created by serdyuk on 6/20/17.
 */
public class HashMapFirstExample {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("One", 12);
        map.put("Two", 15);
        map.put("Three", 45);

        System.out.println(map);
        System.out.println(map.get("Two"));
    }
}
