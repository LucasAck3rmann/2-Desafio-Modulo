import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 * Main game engine class using Singleton pattern
 */
public class GameEngine {
    private static GameEngine instance;
    private Scanner scanner;
    private Character player;
    private List<Enemy> enemies;
    private int battlesWon;
    private int potionsUsed;
    private Random random;

    // Private constructor for Singleton pattern
    private GameEngine() {
        scanner = new Scanner(System.in);
        enemies = new ArrayList<>();
        battlesWon = 0;
        potionsUsed = 0;
        random = new Random();
    }

    /**
     * Gets singleton instance of the game engine
     */
    public static GameEngine getInstance() {
        if (instance == null) {
            instance = new GameEngine();
        }
        return instance;
    }

    /**
     * Initializes the game
     */
    public void startGame() {
        System.out.println("=== D&D BATTLE ARENA ===");
        System.out.println("Welcome to the battle arena!");

        createCharacter();

        boolean continuePlaying = true;
        while (continuePlaying && player.isAlive()) {
            generateEnemies();
            battle();

            if (player.isAlive()) {
                System.out.println("Victory! You've defeated all enemies!");
                battlesWon++;

                System.out.print("Continue to next battle? (y/n): ");
                String choice = scanner.nextLine().trim().toLowerCase();
                continuePlaying = choice.equals("y") || choice.equals("yes");
            }
        }

        endGame();
    }

    private void createCharacter() {
        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();

        System.out.println("Choose your class:");
        System.out.println("1. Warrior (High HP and defense)");
        System.out.println("2. Mage (Powerful spells, low HP)");
        System.out.println("3. Archer (Balanced stats with critical hits)");

        int choice = getValidChoice(1, 3);

        // Factory method pattern to create character
        switch (choice) {
            case 1:
                player = new Warrior(name);
                break;
            case 2:
                player = new Mage(name);
                break;
            case 3:
                player = new Archer(name);
                break;
        }

        System.out.println("\nWelcome, " + player.getName() + "!");
        System.out.println("You have 3 Health Potions in your inventory.");
        System.out.println("Let the battles begin!\n");
    }

    /**
     * Generates random enemies based on player's progress
     */
    private void generateEnemies() {
        enemies.clear();
        int enemyCount = 1 + random.nextInt(2); // 1-2 enemies per battle

        System.out.println("\n=== NEW BATTLE ===");
        System.out.println("You encounter " + enemyCount + " enemies!");

        for (int i = 0; i < enemyCount; i++) {
            Enemy enemy = Enemy.createRandomEnemy(1 + battlesWon / 2);
            enemies.add(enemy);
            System.out.println("- " + enemy.getName() + " appears!");
        }
        System.out.println();
    }

    /**
     * Executes battle sequence
     */
    private void battle() {
        int turn = 1;

        while (player.isAlive() && !enemies.isEmpty()) {
            System.out.println("=== TURN " + turn + " ===");
            displayStatus();

            if (playerTurn()) {
                System.out.println("You flee from battle!");
                return;
            }

            enemies.removeIf(enemy -> !enemy.isAlive());

            if (enemies.isEmpty()) {
                break;
            }

            for (Enemy enemy : enemies) {
                if (enemy.isAlive()) {
                    System.out.println(enemy.takeTurn(player));

                    if (!player.isAlive()) {
                        return;
                    }
                }
            }

            player.endTurn();
            enemies.forEach(Character::endTurn);

            turn++;
            System.out.println();
        }
    }

    /**
     * Handles player's turn
     * @return true if player flees
     */
    private boolean playerTurn() {
        System.out.println("Your turn! Choose an action:");
        System.out.println("1. Attack");
        System.out.println("2. Defend");
        System.out.println("3. Use Health Potion");
        System.out.println("4. Flee");

        int choice = getValidChoice(1, 4);

        switch (choice) {
            case 1:
                playerAttack();
                break;
            case 2:
                player.defend();
                System.out.println("You take a defensive stance!");
                break;
            case 3:
                useHealthPotion();
                break;
            case 4:
                return true;
        }

        return false;
    }

    /**
     * player's attack action
     */
    private void playerAttack() {
        if (enemies.size() == 1) {
            Enemy target = enemies.get(0);
            int damage = player.attack(target);
            System.out.println("You attack " + target.getName() + " for " + damage + " damage!");

            if (!target.isAlive()) {
                System.out.println(target.getName() + " has been defeated!");
            }
        } else {
            System.out.println("Choose an enemy to attack:");
            for (int i = 0; i < enemies.size(); i++) {
                System.out.println((i + 1) + ". " + enemies.get(i).getStatus());
            }

            int targetIndex = getValidChoice(1, enemies.size()) - 1;
            Enemy target = enemies.get(targetIndex);

            int damage = player.attack(target);
            System.out.println("You attack " + target.getName() + " for " + damage + " damage!");

            if (!target.isAlive()) {
                System.out.println(target.getName() + " has been defeated!");
            }
        }
    }

    /**
     * health potion usage
     */
    private void useHealthPotion() {
        int potionCount = 0;
        for (String item : player.getInventory()) {
            if (item.equals("Health Potion")) {
                potionCount++;
            }
        }

        if (potionCount > 0) {
            player.heal(20);
            player.getInventory().remove("Health Potion");
            potionsUsed++;

            System.out.println("You use a Health Potion and restore 20 HP!");
            System.out.println("Current HP: " + player.getCurrentHealth() + "/" + player.getMaxHealth());
            System.out.println("Health Potions remaining: " + (potionCount - 1));
        } else {
            System.out.println("You don't have any Health Potions left!");
            // Let player choose another action
            playerTurn();
        }
    }

    private void displayStatus() {
        System.out.println(player.getStatus());
        System.out.println("\nEnemies:");
        for (Enemy enemy : enemies) {
            System.out.println("- " + enemy.getStatus());
        }
        System.out.println();
    }

    private void endGame() {
        System.out.println("\n=== GAME OVER ===");

        if (player.isAlive()) {
            System.out.println("Congratulations! You've completed your adventure!");
        } else {
            System.out.println("You have been defeated...");
        }

        System.out.println("\nGame Statistics:");
        System.out.println("- Battles won: " + battlesWon);
        System.out.println("- Health potions used: " + potionsUsed);

        System.out.println("\nThank you for playing!");
    }

    private int getValidChoice(int min, int max) {
        int choice = -1;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print("Enter choice (" + min + "-" + max + "): ");
                choice = Integer.parseInt(scanner.nextLine().trim());

                if (choice >= min && choice <= max) {
                    valid = true;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }

        return choice;
    }
}