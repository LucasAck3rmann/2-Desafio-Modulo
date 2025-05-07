public class Mage extends Character {
    private static final int SPELL_DAMAGE_MULTIPLIER = 2;
    private int mana = 100;
    private int maxMana = 100;

    public Mage(String name) {
        super(name, 80, 20, 5);
        addItem("Health Potion");
        addItem("Health Potion");
        addItem("Health Potion");
    }

    /**
     * Mage special ability: Spell Damage
     */
    @Override
    public int attack(Character target) {
        if (mana >= 10) {
            mana -= 10;
            int spellDamage = calculateDamage();
            target.takeDamage(spellDamage);
            return spellDamage;
        } else {
            // Without mana, do a weak attack
            int damage = attackPower / 2;
            target.takeDamage(damage);
            return damage;
        }
    }

    @Override
    protected int calculateDamage() {
        return attackPower * SPELL_DAMAGE_MULTIPLIER;
    }

    /**
     * Regenerate mana each turn
     */
    @Override
    public void endTurn() {
        super.endTurn();
        mana = Math.min(maxMana, mana + 10);
    }

    @Override
    public String getStatus() {
        return super.getStatus() + " | Mana: " + mana + "/" + maxMana;
    }
}