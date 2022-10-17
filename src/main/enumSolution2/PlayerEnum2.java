package main.enumSolution2;

import main.Player;

public class PlayerEnum2 extends Player {

    private HelperEnum2 helper;

    public PlayerEnum2(String name, int stamina, int strength, int intelligence, HelperEnum2 helper, int helperPower) {
        super(name, stamina, strength, intelligence);
        this.helper = helper;
        this.helper.setPower(helperPower);
    }

    @Override
    public void askForHelp() {
        helper.help(this);
    }

    public HelperEnum2 getHelper() {
        return helper;
    }

    public void setHelper(HelperEnum2 helper) {
        this.helper = helper;
    }

}
