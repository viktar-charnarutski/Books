package effectivejava.effectivejava.chapter7.item42.varargs;

/**
 * Use varargs judiciously.
 *
 */
public class MathOperation {

    // the right way to use varargs to pass one or more parameters
    public int min(int first, int... remain) {
        int min = first;
        for (int arg : remain) {
            min = Math.min(arg, min);
        }
        return min;
    }
}
