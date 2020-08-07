public class Circle implements Shape {
    private double radius;

    public Circle(Number radius) {
        this.radius = radius.doubleValue();
    }
    
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getDescription() {
        return ("A circle with radius " + radius);
    }
}