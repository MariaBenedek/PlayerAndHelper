package main.oopSolution.helpers;

import main.oopSolution.PlayerOop;

public class Troll extends Helper {

    public Troll(int power) {
        super(power);
    }

    @Override
    public void help(PlayerOop player) {
        int changeValue = isInTrollMode() ? 0 : power;
        int changeAttribute = (int)(Math.random() * 3);

        switch (changeAttribute) {
            case 0 -> player.setStamina(changeValue);
            case 1 -> player.setStrength(changeValue);
            case 2 -> player.setIntelligence(changeValue);
        }
    }

    private boolean isInTrollMode() {
        return Math.random() < 0.5;
    }

}
