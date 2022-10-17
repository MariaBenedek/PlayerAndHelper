package main.oopSolution;

import main.Player;
import main.oopSolution.helpers.Helper;

public class PlayerOop extends Player {

    private Helper helper;

    public PlayerOop(String name, int stamina, int strength, int intelligence, Helper helper) {
        super(name, stamina, strength, intelligence);
        this.helper = helper;
    }

    @Override
    public void askForHelp() {
        helper.help(this);
    }

    public Helper getHelper() {
        return helper;
    }

    public void setHelper(Helper helper) {
        this.helper = helper;
    }

}
