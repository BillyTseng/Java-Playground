package come.OOD_III.FactoryPatternPractice;

public class ShapeFactory {
    public Shape getShape(ShapeType shapeType) {
        if (shapeType == null) {
            return null;
        }

        switch(shapeType) {
            case CIRCLE:
                return new Circle();
            case SQUARE:
                return new Square();
            case RECTANGLE:
                return new Rectangle();
        }
        return null;
    }
}
