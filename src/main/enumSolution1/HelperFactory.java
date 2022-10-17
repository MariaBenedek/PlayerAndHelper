package main.enumSolution1;

public class HelperFactory {

    private HelperFactory() {}

    static void helpPlayer(PlayerEnum1 player) {
        HelperEnum1 helper = player.getHelper();
        int helperPower = helper.getPower();

        switch (helper) {
            case DEFENDER -> callDefender(player, helperPower);
            case FIGHTER -> callFighter(player, helperPower);
            case HEALER -> callHealer(player, helperPower);
            case TROLL -> callTroll(player, helperPower);
        }
    }

    private static void callDefender(PlayerEnum1 player, int helperPower) {
        player.setBlockedDamage(helperPower);
    }

    private static void callFighter(PlayerEnum1 player, int helperPower) {
        int maxStrength = player.getMaxStrength();
        int maxIntelligence = player.getMaxIntelligence();

        if (maxStrength > maxIntelligence) {
            player.setStrength( Math.min(player.getStrength() + helperPower, maxStrength) );
        } else {
            player.setIntelligence( Math.min(player.getIntelligence() + helperPower, maxIntelligence) );
        }
    }

    private static void callHealer(PlayerEnum1 player, int helperPower) {
        int maxStamina = player.getMaxStamina();
        int healedStamina = player.getStamina();

        if (healedStamina <= maxStamina * 0.25) {
            healedStamina += helperPower * 2;
        } else if (healedStamina < maxStamina * 0.75) {
            healedStamina += helperPower;
        }

        player.setStamina( Math.min(healedStamina, maxStamina) );
    }

    private static void callTroll(PlayerEnum1 player, int helperPower) {
        int changeValue = (Math.random() < 0.5) ? 0 : helperPower;
        int changeAttribute = (int)(Math.random() * 3);

        switch (changeAttribute) {
            case 0 -> player.setStamina(changeValue);
            case 1 -> player.setStrength(changeValue);
            case 2 -> player.setIntelligence(changeValue);
        }
    }

}
