public class Cat extends Animal {
    public Cat(String name) {
        super(name, "Meow");
    }

    public void makeSound() {
        System.out.println(getName() + " makes: " + getSound());
    }

}