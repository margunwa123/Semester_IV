public class BlackBorderDecorator extends ShapeDecorator {

    public BlackBorderDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public String getDescription() {
        return decoratedShape.getDescription() + " with black border";
    }
}