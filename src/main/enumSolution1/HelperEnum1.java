package main.enumSolution1;

public enum HelperEnum1 {

    DEFENDER,
    FIGHTER,
    HEALER,
    TROLL;

    private int power;

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

}
