import java.util.ArrayList;
import java.util.HashSet;

public class ComparingCollections {

    public static void main(String[] args) {
        ArrayList<Integer> numbersList = new ArrayList<>();
        HashSet<Integer> numbersSet = new HashSet<>();

        numbersList.add(10);
        numbersList.add(20);
        numbersList.add(30);
        numbersList.add(40);
        numbersList.add(20);

        numbersSet.add(10);
        numbersSet.add(20);
        numbersSet.add(30);
        numbersSet.add(40);
        numbersSet.add(20);

        System.out.println("ArrayList elements: " + numbersList);
        System.out.println("ArrayList size: " + numbersList.size());

        System.out.println("HashSet elements: " + numbersSet);
        System.out.println("HashSet size: " + numbersSet.size());

        System.out.println("\nExplanation of differences:");
        System.out.println("1. ArrayList maintains insertion order of elements");
        System.out.println("2. HashSet does not guarantee any specific order");
        System.out.println("3. ArrayList allows duplicate elements (notice the duplicate 20)");
        System.out.println("4. HashSet automatically removes duplicates (only one 20 exists)");
    }
}