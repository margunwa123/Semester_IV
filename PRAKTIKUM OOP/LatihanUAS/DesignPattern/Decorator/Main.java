public class Main {
    public static void main(String[] args) {
        Shape circle1 = new RedShapeDecorator( new Circle(5));
        circle1.getDescription();
        Shape circle2 = new BlackBorderDecorator(circle1);

        System.out.println(circle1.getDescription());
        System.out.println(circle2.getDescription());
    }
}