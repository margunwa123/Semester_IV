public class Goose {
    private String name;
    private int honk;

    public Goose(String name, int honk) {
        this.name = name;
        this.honk = honk;
    }
    
    public Goose() {
        this("Horrible", 1);
    }

    public void steal(String thing) {
        System.out.println(this.name + " steals " + thing);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(this.name + " goose says");
        for(int i = 0 ; i < this.honk ; i++) {
            result.append(" honk");
        }
        return result.toString();
    }
}