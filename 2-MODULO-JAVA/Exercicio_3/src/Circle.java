public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    
    /**
     * @param radius new radius value
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        // Area circle = pi * r²
        return Math.PI * radius * radius;
    }
}