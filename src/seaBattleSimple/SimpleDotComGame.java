package seaBattleSimple;

import java.util.List;
import java.util.ArrayList;

public class SimpleDotComGame {
    private List<Integer> userChoose = new ArrayList<>();
    private int[] locationCells;
    private int numOfHits;

    public String checkYourSelf(String guessString) {
        int guess = Integer.parseInt(guessString);
        String result = "miss";
        boolean isExist = false;

        for (Integer anUserChoose1 : userChoose) {
            if (anUserChoose1 == guess) {
                result = "You already choose this num";
                isExist = true;
                break;
            }
        }

        for (int cell : locationCells) {
            if (guess == cell && !isExist) {
                result = "Hit";
                numOfHits++;
                break;
            }
        }

        if (numOfHits == locationCells.length) {
            result = "Kill";
        }

        System.out.println(result);

        userChoose.add(guess);
        return result;
    }

    public void setLocationCells(int[] loc) {
        locationCells = loc;
    }
}