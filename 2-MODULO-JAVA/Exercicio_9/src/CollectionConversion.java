import java.util.ArrayList;
import java.util.HashSet;

public class CollectionConversion {

    public static void main(String[] args) {
        ArrayList<String> wordsList = new ArrayList<>();
        wordsList.add("Java");
        wordsList.add("TypeScript");
        wordsList.add("React");
        wordsList.add("Zod");
        wordsList.add("Java");

        System.out.println("Original ArrayList: " + wordsList);

        HashSet<String> wordsSet = new HashSet<>(wordsList);
        System.out.println("Converted to HashSet: " + wordsSet);

        ArrayList<String> newWordsList = new ArrayList<>(wordsSet);
        System.out.println("Converted back to ArrayList: " + newWordsList);

        System.out.println("\nObservations:");
        System.out.println("1. The original ArrayList maintained duplicates (Java appears twice)");
        System.out.println("2. When converted to HashSet, duplicates were removed");
        System.out.println("3. The order of elements in HashSet is not guaranteed to match the original ArrayList");
        System.out.println("4. When converted back to ArrayList, the order matches the HashSet (not the original)");
        System.out.println("5. Once information about order and duplicates is lost in HashSet, it cannot be recovered");
    }
}