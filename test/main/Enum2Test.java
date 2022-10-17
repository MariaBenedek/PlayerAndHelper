package main;

import main.enumSolution1.HelperEnum1;
import main.enumSolution1.PlayerEnum1;
import main.enumSolution2.HelperEnum2;
import main.enumSolution2.PlayerEnum2;
import org.junit.jupiter.api.Test;

import static main.enumSolution2.HelperEnum2.DEFENDER;
import static main.enumSolution2.HelperEnum2.FIGHTER;
import static main.enumSolution2.HelperEnum2.HEALER;
import static main.enumSolution2.HelperEnum2.TROLL;

import static org.junit.jupiter.api.Assertions.*;

public class Enum2Test {

    @Test
    void player_creation() {
        PlayerEnum2 player = new PlayerEnum2("Jumping", 100, 200, 300, TROLL, 0);

        assertEquals(100, player.getMaxStamina());
        assertEquals(200, player.getMaxStrength());
        assertEquals(300, player.getMaxIntelligence());
        assertStatsEquals(player, 100, 200, 300, 0);
    }

    @Test
    void defender_help() {
        PlayerEnum2 player = testPlayer(DEFENDER, 50);
        player.askForHelp();

        assertStatsEquals(player, 100, 50, 30, 50);
    }

    @Test
    void fighter_help_strength() {
        PlayerEnum2 player = testPlayer(FIGHTER, 30);
        player.setStrength(0);
        player.askForHelp();

        assertStatsEquals(player, 100, 30, 30, 0);
    }

    @Test
    void healer_help() {
        PlayerEnum2 player = testPlayer(HEALER, 20);
        player.setStamina(20);
        player.askForHelp();

        assertStatsEquals(player, 60, 50, 30, 0);
    }

    /**
     *
     * @param helper the {@link HelperEnum1}
     * @param helperPower the power of the helper
     * @return new {@link PlayerEnum1} with stamina 100, strength 50, intelligence 30
     */
    private PlayerEnum2 testPlayer(HelperEnum2 helper, int helperPower) {
        return new PlayerEnum2("Jumping", 100, 50, 30, helper, helperPower);
    }

    /**
     *
     * @param player the {@link PlayerEnum1}
     * @param stamina the expected stamina of the player
     * @param strength the expected strength of the player
     * @param intelligence the expected intelligence of the player
     * @param block the expected block of the player
     */
    private void assertStatsEquals(PlayerEnum2 player, int stamina, int strength, int intelligence, int block) {
        assertEquals(stamina, player.getStamina());
        assertEquals(strength, player.getStrength());
        assertEquals(intelligence, player.getIntelligence());
        assertEquals(block, player.getBlockedDamage());
    }

}
