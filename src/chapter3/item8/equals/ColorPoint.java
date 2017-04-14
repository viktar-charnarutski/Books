package chapter3.item8.equals;

import java.awt.*;

/**
 * Class demonstrates benefits of composition over inheritance.
 * Also, a public view of Point should be added.
 * <p>
 * Rules for equal overriding:
 * <ul>
 * <li>Use the == operator to check if the argument is a reference to itself.</li>
 * <li>Use {@code instanceOf} operator to check if the argument has the correct type.</li>
 * <li>Cast the argument to the correct type.</li>
 * <li>For each significant field of the object check if that field of the argument matches to the corresponding
 * field of the object.</li>
 * <li>Ask yourself if the {@code equals}</li> overriding is: symmetric, transient and consistent.
 * </ul>
 */
public class ColorPoint {
    private final Point point;
    private final Color color;

    public ColorPoint(int x, int y, Color c) {
        this.point = new Point(x, y);
        this.color = c;
    }

    // Returns the point-view of this color point.
    public Point asPoint() {
        return this.point;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof ColorPoint)) return false;
        if (o == this) return true;
        ColorPoint cp = (ColorPoint) o;
        return cp.point.equals(this.point) && cp.color.equals(color);
    }
}
