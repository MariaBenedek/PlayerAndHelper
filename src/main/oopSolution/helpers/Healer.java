package main.oopSolution.helpers;

import main.oopSolution.PlayerOop;

public class Healer extends Helper {

    public Healer(int power) {
        super(power);
    }

    @Override
    public void help(PlayerOop player) {
        int maxStamina = player.getMaxStamina();
        int healedStamina = player.getStamina();

        if (healedStamina <= maxStamina * 0.25) {
            healedStamina += power * 2;
        } else if (healedStamina < maxStamina * 0.75) {
            healedStamina += power;
        }

        player.setStamina( Math.min(healedStamina, maxStamina) );
    }

}
