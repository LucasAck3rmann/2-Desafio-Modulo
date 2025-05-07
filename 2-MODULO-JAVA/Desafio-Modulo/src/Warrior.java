public class Warrior extends Character {
    private static final int RAGE_ATTACK_BONUS = 5;
    private boolean rageActive = false;

    public Warrior(String name) {
        super(name, 150, 15, 10);
        addItem("Health Potion");
        addItem("Health Potion");
        addItem("Health Potion");
    }

    /**
     * Warrior special ability: Rage
     */
    @Override
    protected int calculateDamage() {
        // Strategy pattern: Different damage calculation based on state
        if (currentHealth < maxHealth * 0.3) {
            rageActive = true;
            return attackPower + RAGE_ATTACK_BONUS;
        }
        rageActive = false;
        return attackPower;
    }

    /**
     * Enhanced status display with rage information
     */
    @Override
    public String getStatus() {
        String status = super.getStatus();
        if (rageActive) {
            status += " | RAGE ACTIVE";
        }
        return status;
    }
}




