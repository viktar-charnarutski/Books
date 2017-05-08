package effectivejava.chapter6.item30.enums;

/**
 * Enum type with data and behavior.
 */
public enum Planet {
    MERCURY(3.302E+23, 2.439E6),
    VENUS(4.869E+24, 6.052E6),
    EARTH(5.975E+24, 6.378E6),
    MARS(6.419E+23, 3.393E6),
    JUPITER(1.899E+27, 7.149E7),
    SATURN(5.685E+26, 6.027E7),
    URANUS(8.683E+25, 2.556E7),
    NEPTUNE(1.024E+26, 2.477E7);

    private final double mass; // in kilos
    private final double radius; // in meters
    private final double surfaceGravity; // in m /s^2

    // universal gravitational constant in m^3 / kg s^2
    private static final double G = 6.67300E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        this.surfaceGravity = G * mass / (radius * radius);
    }

    public double mass() {
        return mass;
    }

    public double radius() {
        return radius;
    }

    public double surfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity; // F = ma
    }
}
