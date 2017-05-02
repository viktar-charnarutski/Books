package effectivejava.chapter4.item17.hierarchy;

/**
 * Rectangle as a subclass of Figure.
 */
public class Rectangle extends Figure {

    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double length() {
        return length;
    }

    public double width() {
        return width;
    }

    @Override
    public double area() {
        return length() * width();
    }
}
