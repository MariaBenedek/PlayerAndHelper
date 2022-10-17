package main.enumSolution1;

import main.Player;

public class PlayerEnum1 extends Player {

    private HelperEnum1 helper;

    public PlayerEnum1(String name, int stamina, int strength, int intelligence, HelperEnum1 helper, int helperPower) {
        super(name, stamina, strength, intelligence);
        this.helper = helper;
        this.helper.setPower(helperPower);
    }

    @Override
    public void askForHelp() {
        HelperFactory.helpPlayer(this);
    }

    public HelperEnum1 getHelper() {
        return helper;
    }

    public void setHelper(HelperEnum1 helper) {
        this.helper = helper;
    }

}
