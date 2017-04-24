package chapter4.item15.mutability;

/**
 * Immutable class with a static factory instead of constructor.
 * <p>
 * Rules to make a class immutable:
 * <ul>
 * <li>Don't provide any method that modifies the object's state.</li>
 * <li>Ensure that the class can't be extended.</li>
 * <li>Make all field final.</li>
 * <li>Make all fields private.</li>
 * <li>Ensure exclusive access to any mutable components.</li>
 * </ul>
 */
public class Complex {
    private final double re;
    private final double im;

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }

    // accessors with no corresponding mutators
    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public Complex add(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex subtract(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex multiply(Complex c) {
        return new Complex(re * c.re - im * c.im, re * c.re + im * c.im);
    }

    public Complex devide(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Complex)) return false;

        Complex c = (Complex) obj;
        return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17 + hashDouble(im);
        result = 31 * result + hashDouble(re);
        return result;
    }

    private int hashDouble(double val) {
        long longBits = Double.doubleToLongBits(val);
        return (int) (longBits ^ (longBits >>> 32));
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + ")";
    }
}
