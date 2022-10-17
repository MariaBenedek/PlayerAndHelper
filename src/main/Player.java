package main;

public abstract class Player {

    private final String name;

    private final int maxStamina;
    private final int maxStrength;
    private final int maxIntelligence;

    private int stamina;
    private int strength;
    private int intelligence;
    private int blockedDamage;

    public Player(String name, int stamina, int strength, int intelligence) {
        this.name = name;

        this.maxStamina = stamina;
        this.maxStrength = strength;
        this.maxIntelligence = intelligence;

        this.stamina = stamina;
        this.strength = strength;
        this.intelligence = intelligence;
    }

    public abstract void askForHelp();

    public String getName() {
        return name;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public int getMaxStrength() {
        return maxStrength;
    }

    public int getMaxIntelligence() {
        return maxIntelligence;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getBlockedDamage() {
        return blockedDamage;
    }

    public void setBlockedDamage(int blockedDamage) {
        this.blockedDamage = blockedDamage;
    }

}
