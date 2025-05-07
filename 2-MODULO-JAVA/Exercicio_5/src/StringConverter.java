public class StringConverter {

    public static void main(String[] args) {
        String validNumber = "171";
        String invalidNumber = "D";

        convertStringToInt(validNumber);

        convertStringToInt(invalidNumber);
    }

    public static void convertStringToInt(String str) {
        try {
            int number = Integer.parseInt(str);
            System.out.println("Successfully converted to integer: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Error: Cannot convert '" + str + "' to an integer");
        } finally {
            System.out.println("Finally block executed - process completed");
        }

        System.out.println("--------------------");
    }
}