public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    /**
     * @param width new width value
     */
    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    /**
     * @param height new height value
     */
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calculateArea() {
        // Area rectangle = width * height
        return width * height;
    }
}