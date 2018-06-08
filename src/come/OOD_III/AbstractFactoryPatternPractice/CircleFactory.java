package come.OOD_III.AbstractFactoryPatternPractice;

public class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}
