public class Human extends Animal {
    public Human() {
        super(2);
    }

    @Override
    public void eat(String food) {
        if(!food.equals("teman")) {
            this.hungry = false;
        }
    }

    @Override
    public void run() {
        System.out.println("Human is running");
    }
}