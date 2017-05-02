package effectivejava.chapter4.item17.hierarchy;

/**
 * Circle as a subclass of Figure.
 */
public class Circle extends Figure {
    private final double radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public double radius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * radius() * radius();
    }
}
