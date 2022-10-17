package main.oopSolution.helpers;

import main.oopSolution.PlayerOop;

public class Defender extends Helper {

    public Defender(int power) {
        super(power);
    }

    @Override
    public void help(PlayerOop player) {
        player.setBlockedDamage(power);
    }

}
