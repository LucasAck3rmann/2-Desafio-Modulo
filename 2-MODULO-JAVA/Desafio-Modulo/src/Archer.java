public class Archer extends Character {
    private static final double CRIT_CHANCE = 0.25;
    private static final double CRIT_MULTIPLIER = 1.5;

    public Archer(String name) {
        super(name, 100, 18, 7);
        addItem("Health Potion");
        addItem("Health Potion");
        addItem("Health Potion");
    }

    /**
     * Archer special ability: Critical hits
     */
    @Override
    protected int calculateDamage() {
        // Strategy pattern: Random chance
        if (Math.random() < CRIT_CHANCE) {
            return (int)(attackPower * CRIT_MULTIPLIER);
        }
        return attackPower;
    }
}