import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    protected String name;
    protected int maxHealth;
    protected int currentHealth;
    protected int attackPower;
    protected int defense;
    protected boolean isDefending;
    protected List<String> inventory;

    public Character(String name, int health, int attackPower, int defense) {
        this.name = name;
        this.maxHealth = health;
        this.currentHealth = health;
        this.attackPower = attackPower;
        this.defense = defense;
        this.isDefending = false;
        this.inventory = new ArrayList<>();
    }

    /**
     * Attacks target returns damage
     */
    public int attack(Character target) {
        int damage = calculateDamage();
        target.takeDamage(damage);
        return damage;
    }

    protected int calculateDamage() {
        return attackPower;
    }

    public void defend() {
        isDefending = true;
    }

    public void takeDamage(int damage) {
        int actualDamage = damage;

        if (isDefending) {
            actualDamage = Math.max(1, damage / 2);
            isDefending = false;
        } else {
            actualDamage = Math.max(1, damage - defense);
        }

        currentHealth = Math.max(0, currentHealth - actualDamage);
    }

    public void endTurn() {
        isDefending = false;
    }

    public boolean isAlive() {
        return currentHealth > 0;
    }

    public String getName() {
        return name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public void addItem(String item) {
        inventory.add(item);
    }

    public void heal(int amount) {
        currentHealth = Math.min(maxHealth, currentHealth + amount);
    }

    public String getStatus() {
        return name + " - HP: " + currentHealth + "/" + maxHealth +
                " | ATK: " + attackPower + " | DEF: " + defense;
    }
}