package lynda.java.lambda;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class CustomFunctionalInterface {

    @java.lang.FunctionalInterface
    interface Calculate {
        int compute(int a, int b);
    }


    public static void main(String[] args) {
        List<Calculate> operations = new ArrayList<>();
        operations.add((a, b) -> a + b);
        operations.add((a, b) -> Math.abs(a - b));
        operations.add((a, b) -> a * b);
        operations.add((a, b) -> (b != 0 ? a / b : 0));

        for (Calculate calc : operations) {
            System.out.println(calc.compute(1, 2));
        }
    }
}
