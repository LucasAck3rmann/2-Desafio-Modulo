/**
 * Main class to test the Shape implementations
 */
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("Circle area: " + circle.calculateArea());

        Rectangle rectangle = new Rectangle(4, 6);
        System.out.println("Rectangle area: " + rectangle.calculateArea());

        Shape shape1 = new Circle(3);
        Shape shape2 = new Rectangle(2, 8);

        System.out.println("Shape1 area (Circle): " + shape1.calculateArea());
        System.out.println("Shape2 area (Rectangle): " + shape2.calculateArea());
    }
}