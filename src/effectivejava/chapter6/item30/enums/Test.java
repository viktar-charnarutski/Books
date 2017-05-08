package effectivejava.chapter6.item30.enums;

/**
 *
 */
public class Test {
    public static void main(String[] args) {
        double earthWeight = 87.7;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet planet : Planet.values()) {
            System.out.printf("Weight on %s is %f%n", planet, planet.surfaceWeight(mass));
        }
    }
}
