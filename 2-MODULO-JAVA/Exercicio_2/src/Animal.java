public class Animal {
    private String name;
    private String sound;

    public Animal(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    // Getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}