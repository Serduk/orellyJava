package edu.servletsExample;

/**
 * Examples for Servlets.
 * How use it, etc
 * Created by sserdiuk on 6/27/17.
 */
public class EnvironmetnForServletWorkExamples {
            public static String makePhrase() {
                String[] wordListOne = {"1.1", "1.2", "1.3", "1.4", "1.5"};
                String[] wordListTwo = {"2.1", "2.2", "2.3", "2.4", "2.5"};
                String[] wordListThree = {"3.1", "3.2", "3.3", "3.4", "3.5"};

                int oneLength = wordListOne.length;
                int twoLength = wordListTwo.length;
                int three = wordListThree.length;

                int randOne = (int) (Math.random() * oneLength);
                int randTwo = (int) (Math.random() * twoLength);
                int randTrhee = (int) (Math.random() * twoLength);

                String phrase = wordListOne[randOne] + " " + wordListTwo[randTwo] + " " + wordListThree[randTrhee];

                return phrase;
            }
}
