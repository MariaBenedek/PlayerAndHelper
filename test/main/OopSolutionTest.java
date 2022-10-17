package main;

import main.oopSolution.PlayerOop;
import main.oopSolution.helpers.Defender;
import main.oopSolution.helpers.Fighter;
import main.oopSolution.helpers.Healer;
import main.oopSolution.helpers.Helper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OopSolutionTest {

    @Test
    void player_creation() {
        PlayerOop player = new PlayerOop("Jack", 100, 200, 300, null);

        assertEquals(100, player.getMaxStamina());
        assertEquals(100, player.getStamina());
        assertEquals(200, player.getMaxStrength());
        assertEquals(200, player.getStrength());
        assertEquals(300, player.getMaxIntelligence());
        assertEquals(300, player.getIntelligence());
        assertEquals(0, player.getBlockedDamage());
    }

    @Test
    void defender_noChangeOnOtherStats() {
        PlayerOop player = testPlayer(new Defender(20), false);

        player.askForHelp();

        assertEquals(100, player.getStamina());
        assertEquals(10, player.getStrength());
        assertEquals(30, player.getIntelligence());
    }

    @Test
    void defender_setsBlockToHisPower() {
        PlayerOop player = testPlayer(new Defender(20), false);
        assertBlockEquals(player);

        player = testPlayer(new Defender(50), false);
        assertBlockEquals(player);

        player = testPlayer(new Defender(Integer.MAX_VALUE), false);
        assertBlockEquals(player);

        player.setBlockedDamage(200);
        assertBlockEquals(player);
    }

    @Test
    void defender_changesBlockNotIncrease() {
        PlayerOop player = testPlayer(new Defender(20), false);

        player.askForHelp();
        player.askForHelp();
        player.askForHelp();

        assertBlockEquals(player);
    }

    @Test
    void fighter_noChangeOnOtherStats() {
        PlayerOop player = testPlayer(new Fighter(20), false);

        player.askForHelp();

        assertEquals(100, player.getStamina());
        assertEquals(0, player.getBlockedDamage());
    }

    @Test
    void fighter_changeOnlyStrengthIfItIsHigher() {
        PlayerOop player = testPlayer(new Fighter(20), true);

        assertStrengthEquals(player, 0, 20);
        assertEquals(30, player.getIntelligence());
    }

    @Test
    void fighter_changeOnlyIntelligenceIfItIsHigher() {
        PlayerOop player = testPlayer(new Fighter(20), false);

        assertIntelligenceEquals(player, 0, 20);
        assertEquals(10, player.getStrength());
    }

    @Test
    void fighter_doesNotExceedMaxStrength() {
        PlayerOop playerStr = testPlayer(new Fighter(20), true);

        assertStrengthEquals(playerStr, 50, 50);
        assertStrengthEquals(playerStr, 40, 50);
    }

    @Test
    void fighter_doesNotExceedMaxIntelligence() {
        PlayerOop playerInt = testPlayer(new Fighter(20), false);

        assertIntelligenceEquals(playerInt, 30, 30);
        assertIntelligenceEquals(playerInt, 20, 30);
    }

    /**
     * TODO - is this behaviour a bug or a feature?
     */
    @Test
    void fighter_decreasesIfStrengthIsAboveMax() {
        PlayerOop player = testPlayer(new Fighter(200), true);

        assertStrengthEquals(player, 200, 50);
    }

    @Test
    void healer_noChangeOnOtherStats() {
        PlayerOop player = testPlayer(new Healer(20), false);

        player.askForHelp();

        assertEquals(10, player.getStrength());
        assertEquals(30, player.getIntelligence());
        assertEquals(0, player.getBlockedDamage());
    }

    @Test
    void healer_noHelpIfStaminaIsAbove75Percentage() {
        PlayerOop player = testPlayer(new Healer(20), false);

        assertStaminaEquals(player, 100, 100);
        assertStaminaEquals(player, 75, 75);
    }

    @Test
    void healer_healWithPowerIfStaminaIsBetween25And75Percentage() {
        PlayerOop player = testPlayer(new Healer(20), false);

        assertStaminaEquals(player, 74, 94);
        assertStaminaEquals(player, 26, 46);
    }

    @Test
    void healer_healWithMultiplyPowerIfStaminaIsBelowOrAt25Percentage() {
        PlayerOop player = testPlayer(new Healer(20), false);

        assertStaminaEquals(player, 25, 65);
        assertStaminaEquals(player, 1, 41);
    }

    @Test
    void healer_doesNotExceedMaxStamina() {
        PlayerOop player = testPlayer(new Healer(200), false);

        assertStaminaEquals(player, 74, 100);
        assertStaminaEquals(player, 1, 100);
    }

    /**
     * TODO - is this behaviour a bug or a feature?
     */
    @Test
    void healer_decreasesIfStaminaIsAboveMax() {
        PlayerOop player = testPlayer(new Healer(200), false);

        assertStaminaEquals(player, 200, 100);
    }

    /**
     *
     * @param helper the {@link Helper}
     * @param setStrengthHigher if false, strength is set to 10, 50 otherwise
     * @return new player with stamina 100, strength 10 or 50, intelligence 30
     */
    private PlayerOop testPlayer(Helper helper, boolean setStrengthHigher) {
        int str = setStrengthHigher ? 50 : 10;

        return new PlayerOop("Jack", 100, str, 30, helper);
    }

    /**
     * Asks the helper ({@link Defender} of the {@link PlayerOop} to help,
     * then checks that the player's block has changed correctly.
     * <br>
     * After the help, the player's block is equals to the helper's power.
     *
     * @param player the {@link PlayerOop} object
     */
    private void assertBlockEquals(PlayerOop player) {
        player.askForHelp();
        assertEquals(player.getHelper().getPower(), player.getBlockedDamage());
    }

    /**
     * Sets the player's stamina to the given value, then asks the helper of the player to help.
     * Finally checks that the player's stamina has changed correctly.
     *
     * @param player the {@link PlayerOop} object
     * @param playerCurrent the stamina of the player before the help of the {@link Helper}
     * @param expected the expected stamina of the player after the help of the {@link Helper}
     */
    private void assertStaminaEquals(PlayerOop player, int playerCurrent, int expected) {
        player.setStamina(playerCurrent);
        player.askForHelp();
        assertEquals(expected, player.getStamina());
    }

    /**
     * Sets the player's strength to the given value, then asks the helper of the player to help.
     * Finally checks that the player's strength has changed correctly.
     *
     * @param player the {@link PlayerOop} object
     * @param playerCurrent the strength of the player before the help of the {@link Helper}
     * @param expected the expected strength of the player after the help of the {@link Helper}
     */
    private void assertStrengthEquals(PlayerOop player, int playerCurrent, int expected) {
        player.setStrength(playerCurrent);
        player.askForHelp();
        assertEquals(expected, player.getStrength());
    }

    /**
     * Sets the player's intelligence to the given value, then asks the helper of the player to help.
     * Finally checks that the player's intelligence has changed correctly.
     *
     * @param player the {@link PlayerOop} object
     * @param playerCurrent the intelligence of the player before the help of the {@link Helper}
     * @param expected the expected intelligence of the player after the help of the {@link Helper}
     */
    private void assertIntelligenceEquals(PlayerOop player, int playerCurrent, int expected) {
        player.setIntelligence(playerCurrent);
        player.askForHelp();
        assertEquals(expected, player.getIntelligence());
    }

}