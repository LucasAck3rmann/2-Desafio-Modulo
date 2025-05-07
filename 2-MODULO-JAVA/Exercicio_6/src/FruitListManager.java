import java.util.ArrayList;

public class FruitListManager {
    
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Tomato");
        fruits.add("Watermelon");
        fruits.add("Kiwi");
        fruits.add("Strawberry");

        System.out.println("Size of the fruit list: " + fruits.size());

        System.out.println("Third fruit in the list: " + fruits.get(2));

        String removedFruit = fruits.remove(0);
        System.out.println("Removed fruit: " + removedFruit);

        String fruitToFind = "Mango";
        boolean exists = fruits.contains(fruitToFind);
        System.out.println("Does the list contain " + fruitToFind + "? " + exists);

        System.out.println("All fruits in the list:");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }
    }
}