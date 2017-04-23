package edu.seaBattle;

import java.util.ArrayList;

/**
 * Class with logic for sea battle
 * <p>
 * Created by serdyuk on 2/18/17.
 */
public class DotCom {
    private ArrayList<String> locationCells;
    private String siteName = "";

    public String checkYourSelf(String userInput) {
        String result = "Miss";
        int index = locationCells.indexOf(userInput);

        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "Kill";
                System.out.println("Oops, You kill " + siteName + " :-( ");
            } else {
                result = "Hit";
            }
        }
        return result;
    }

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    public void setName(String siteName) {
        this.siteName = siteName;
    }
}
