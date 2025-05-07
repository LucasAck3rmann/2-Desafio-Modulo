public class Dog extends Animal {
    public Dog(String name) {
        super(name, "Woof Woof");
    }

    public void makeSound() {
        System.out.println(getName() + " makes: " + getSound());
    }
}