package main.enumSolution2;

public enum HelperEnum2 {

    DEFENDER {
        @Override
        public void help(PlayerEnum2 player) {
            player.setBlockedDamage(this.getPower());
        }
    },

    FIGHTER {
        @Override
        public void help(PlayerEnum2 player) {
            int helperPower = this.getPower();
            int maxStrength = player.getMaxStrength();
            int maxIntelligence = player.getMaxIntelligence();

            if (maxStrength > maxIntelligence) {
                player.setStrength( Math.min(player.getStrength() + helperPower, maxStrength) );
            } else {
                player.setIntelligence( Math.min(player.getIntelligence() + helperPower, maxIntelligence) );
            }
        }
    },

    HEALER {
        @Override
        public void help(PlayerEnum2 player) {
            int helperPower = this.getPower();
            int maxStamina = player.getMaxStamina();
            int healedStamina = player.getStamina();

            if (healedStamina <= maxStamina * 0.25) {
                healedStamina += helperPower * 2;
            } else if (healedStamina < maxStamina * 0.75) {
                healedStamina += helperPower;
            }

            player.setStamina( Math.min(healedStamina, maxStamina) );
        }
    },

    TROLL {
        @Override
        public void help(PlayerEnum2 player) {
            int changeValue = (Math.random() < 0.5) ? 0 : this.getPower();
            int changeAttribute = (int)(Math.random() * 3);

            switch (changeAttribute) {
                case 0 -> player.setStamina(changeValue);
                case 1 -> player.setStrength(changeValue);
                case 2 -> player.setIntelligence(changeValue);
            }
        }
    };

    private int power;

    public abstract void help(PlayerEnum2 player);

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

}
