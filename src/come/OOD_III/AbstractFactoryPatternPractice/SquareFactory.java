package come.OOD_III.AbstractFactoryPatternPractice;

public class SquareFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Square();
    }
}
