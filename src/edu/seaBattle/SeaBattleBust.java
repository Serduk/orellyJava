package edu.seaBattle;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class for sea battle game
 * <p>
 * Created by serdyuk on 2/18/17.
 */
public class SeaBattleBust {
    private GameHelper helper = new GameHelper();
    private List<DotCom> dotComList = new ArrayList<DotCom>();
    private int numOfGuess;

    private void setUpGame() {
        DotCom one = new DotCom();
        one.setName("Pets.com");

        DotCom two = new DotCom();
        two.setName("eToys.com");

        DotCom three = new DotCom();
        three.setName("go2.com");

        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        System.out.println("You target: Kill three ships");
        System.out.println(dotComList.get(0) + " " + dotComList.get(1) + " " + dotComList.get(2));
        System.out.println("Try kill it for minimum num of steps");

        for (DotCom dotComToSet : dotComList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }


    }

    private void startPlaying() {
        while (!dotComList.isEmpty()) {
            String userGuess = helper.getUserInput("Please do your action");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuess++;
        String result = "Miss";

        for (DotCom dotComToTest : dotComList) {
            result = dotComToTest.checkYourSelf(userGuess);

            if (result.toLowerCase().equals("hit")) {
                break;
            }

            if (result.toLowerCase().equals("kill")) {
                dotComList.remove(dotComToTest);
                break;
            }
        }

        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("You was kill all ships!");
        if (numOfGuess <= 18) {
            System.out.println("You try " + numOfGuess + " Changes");
            System.out.println("You tries less than " + numOfGuess);
        } else {
            System.out.println("You has " + numOfGuess + "tries. It's to much");
        }

    }

    public static void main(String[] args) {
        SeaBattleBust game = new SeaBattleBust();

        game.setUpGame();
        game.startPlaying();
    }
}
