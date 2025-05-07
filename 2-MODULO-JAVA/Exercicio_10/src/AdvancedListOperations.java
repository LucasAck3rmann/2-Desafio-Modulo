import java.util.ArrayList;
import java.util.HashSet;

public class AdvancedListOperations {
    
    public static void main(String[] args) {
        ArrayList<Integer> numbersList = new ArrayList<>();
        
        numbersList.add(1);
        numbersList.add(2);
        numbersList.add(3);
        numbersList.add(4);
        numbersList.add(5);
        numbersList.add(6);
        numbersList.add(7);
        numbersList.add(8);
        numbersList.add(9);
        numbersList.add(10);
        
        System.out.println("Original list: " + numbersList);

        numbersList.removeIf(number -> number % 2 == 0);
        
        System.out.println("List after removing even numbers: " + numbersList);
        
        HashSet<Integer> oddNumbersSet = new HashSet<>(numbersList);
        System.out.println("HashSet of odd numbers: " + oddNumbersSet);
        
        int numberToCheck = 5;
        boolean contains = oddNumbersSet.contains(numberToCheck);
        System.out.println("Does the set contain " + numberToCheck + "? " + contains);
        
        int anotherNumberToCheck = 6;
        contains = oddNumbersSet.contains(anotherNumberToCheck);
        System.out.println("Does the set contain " + anotherNumberToCheck + "? " + contains);
    }
}