package edu.seriazableExample;

import java.io.Serializable;

/**
 * Describe Character for game
 * Created by serdyuk on 5/26/17.
 */
public class GameCharacter implements Serializable {
    private int power;
    private String type;
    private String[] weapons;
    public GameCharacter (int power, String type, String[] weapons) {
        this.power = power;
        this.type = type;
        this.weapons = weapons;
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    public String getWeapons() {
        String weaponsList = "";
        for (String weapon : weapons) {
            weaponsList += weapon + " ";
        }
        return weaponsList;
    }
}