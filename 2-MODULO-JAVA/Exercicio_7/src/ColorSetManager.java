import java.util.HashSet;

public class ColorSetManager {
    
    public static void main(String[] args) {
        HashSet<String> colors = new HashSet<>();
        
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Purple");
        
        System.out.println("Size of the color set: " + colors.size());
        
        boolean added = colors.add("Blue");
        System.out.println("Was 'Blue' added again? " + added);
        System.out.println("Size after trying to add duplicate: " + colors.size());
        
        boolean removed = colors.remove("Yellow");
        System.out.println("Was 'Yellow' removed? " + removed);
        
        String colorToFind = "Green";
        boolean exists = colors.contains(colorToFind);
        System.out.println("Does the set contain " + colorToFind + "? " + exists);
        
        System.out.println("All colors in the set:");
        for (String color : colors) {
            System.out.println("- " + color);
        }
    }
}