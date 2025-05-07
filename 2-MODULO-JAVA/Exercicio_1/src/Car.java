public class Car {
    private String brand;
    private String model;
    private int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getDescription() {
        return "Brand: " + brand + ", Model: " + model + ", Year: " + year;
    }

    public static void main(String[] args) {
        Car myCar = new Car("Koenigsegg", "Agera R", 2022);
        System.out.println(myCar.getDescription());
    }
}