package come.OOD_III.AbstractFactoryPatternPractice;

public class TestAbstractFactoryPattern {
    public static void main(String[] args) {
        Shape shape1 = new CircleFactory().createShape();
        shape1.draw();

        Shape shape2 = new RectangleFactory().createShape();
        shape2.draw();

        Shape shape3 = new SquareFactory().createShape();
        shape3.draw();
    }
}
