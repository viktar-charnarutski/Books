package effectivejava.chapter3.item8.equals;

/**
 * Simple immutable two-dimensional integer point class.
 */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Point)) return false;
        if (o == this) return true;
        Point p = (Point) o;
        return p.x == this.x && p.y == this.y;
    }
}
