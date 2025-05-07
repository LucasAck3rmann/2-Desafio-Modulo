public class DivisionCalculator {
    
    public static void main(String[] args) {
        int numerator = 12;
        int denominator = 0;

        divide(numerator, denominator);

        divide(12, 2);
    }

    public static void divide(int numerator, int denominator) {
        try {
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero");
        }
    }
}