package chapter2.item2.builder;

/**
 * Builder pattern is a good choice when designing classes whose constructors or static factories would have more than
 * a handful of parameters.
 * <p>
 * <p>Pros:
 * <ul>
 * <li>simulates named optional parameters</li>
 * <li>can check passed parameters and throw IlligalArgumentException if needed</li>
 * </ul>
 * </p>
 * <p>
 * <p>Cons:
 * <ul>
 * <li>to create an object you have first to create a builder</li>
 * </ul>
 * </p>
 */
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // required
        private final int servingSize;
        private final int servings;

        // optional
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
