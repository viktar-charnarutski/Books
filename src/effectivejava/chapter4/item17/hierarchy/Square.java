package effectivejava.chapter4.item17.hierarchy;

/**
 * Square as a subclass of Rectangle - a special kind of rectangle.
 */
public class Square extends Rectangle {

    public Square(double side) {
        super(side, side);
    }
}
