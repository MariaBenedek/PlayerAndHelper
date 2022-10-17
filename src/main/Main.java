package main;

import main.enumSolution1.HelperEnum1;
import main.enumSolution1.PlayerEnum1;
import main.enumSolution2.HelperEnum2;
import main.enumSolution2.PlayerEnum2;
import main.oopSolution.PlayerOop;
import main.oopSolution.helpers.Troll;

public class Main {

    public static void main(String[] args) {
        PlayerOop playerOop = new PlayerOop("OOP", 100, 100, 100,
                new Troll(1000));
        playerOop.askForHelp();

        PlayerEnum1 playerEnum1 = new PlayerEnum1("Enum One", 100, 100, 100,
                HelperEnum1.TROLL, 1000);
        playerEnum1.askForHelp();

        PlayerEnum2 playerEnum2 = new PlayerEnum2("Enum Two", 100, 100, 100,
                HelperEnum2.TROLL, 1000);
        playerEnum2.askForHelp();
    }
}
