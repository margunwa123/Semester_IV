public class Cow extends Animal {
    public Cow() {
        super(4);
    }

    @Override
    public void eat(String food) {
        if(food.equals("grass")) {
            this.hungry = false;
        }
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Cow is running");
    }
}