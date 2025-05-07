import java.util.Random;

public class Enemy extends Character {
    private static final Random random = new Random();

    // Factory method pattern used for creating random enemies
    public static Enemy createRandomEnemy(int playerLevel) {
        String[] names = {
                "Goblin", "Orc", "Troll", "Skeleton", "Zombie",
                "Dark Elf", "Kobold", "Bugbear", "Hobgoblin", "Gnoll"
        };

        String name = names[random.nextInt(names.length)];

        // enemy stats have based on player level
        int health = 50 + random.nextInt(10) * playerLevel;
        int attack = 8 + random.nextInt(3) * playerLevel;
        int defense = 3 + random.nextInt(2) * playerLevel;

        return new Enemy(name, health, attack, defense);
    }

    public Enemy(String name, int health, int attackPower, int defense) {
        super(name, health, attackPower, defense);
    }

    public String takeTurn(Character player) {
        // 70% chance attack, 30% chance defend
        if (random.nextDouble() < 0.7) {
            int damage = attack(player);
            return name + " attacks you for " + damage + " damage!";
        } else {
            defend();
            return name + " takes a defensive stance!";
        }
    }
}