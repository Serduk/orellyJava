package edu.mainRun.DataStructure;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * another one Example with TreeSet
 * Created by serdyuk on 6/20/17.
 */
public class TreeSetMoreExamples {
    public static void main(String[] args) {
        new TreeSetMoreExamples().go();
    }

    void go() {
        BookForTest b1 = new BookForTest("one");
        BookForTest b2 = new BookForTest("two");
        BookForTest b3 = new BookForTest("three");

        TreeSet<BookForTest> books = new TreeSet<BookForTest>();
        books.add(b1);
        books.add(b2);
        books.add(b3);

        System.out.println(books);
    }



    class BookForTest implements Comparable<BookForTest>{
        String title;
        BookForTest(String title) {
            this.title = title;
        }

        @Override
        public int compareTo(BookForTest o) {
            return title.compareTo(o.title);
        }
    }
}
