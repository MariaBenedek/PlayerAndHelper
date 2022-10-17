package main.oopSolution.helpers;

import main.oopSolution.PlayerOop;

public class Fighter extends Helper {

    public Fighter(int power) {
        super(power);
    }

    @Override
    public void help(PlayerOop player) {
        int maxStrength = player.getMaxStrength();
        int maxIntelligence = player.getMaxIntelligence();

        if (maxStrength > maxIntelligence) {
            player.setStrength( Math.min(player.getStrength() + power, maxStrength) );
        } else {
            player.setIntelligence( Math.min(player.getIntelligence() + power, maxIntelligence) );
        }
    }
}
