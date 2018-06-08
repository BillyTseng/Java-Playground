package come.OOD_III.FactoryPatternPractice;

public class TestFactoryPattern {
    public static void main(String[] args) {
        Shape shape1 = new ShapeFactory().getShape(ShapeType.CIRCLE);
        shape1.draw();

        Shape shape2 = new ShapeFactory().getShape(ShapeType.RECTANGLE);
        shape2.draw();

        Shape shape3 = new ShapeFactory().getShape(ShapeType.SQUARE);
        shape3.draw();
    }
}
