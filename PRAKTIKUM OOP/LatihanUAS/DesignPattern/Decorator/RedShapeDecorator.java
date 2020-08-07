public class RedShapeDecorator extends ShapeDecorator {
    
    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public String getDescription() {
        return decoratedShape.getDescription() + " with red color";
    }
}