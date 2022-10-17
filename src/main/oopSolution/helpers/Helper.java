package main.oopSolution.helpers;

import main.oopSolution.PlayerOop;

public abstract class Helper {

    protected final int power;

    public Helper(int power) {
        this.power = power;
    }

    public abstract void help(PlayerOop player);

    public int getPower() {
        return power;
    }
}
