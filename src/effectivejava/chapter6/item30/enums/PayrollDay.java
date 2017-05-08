package effectivejava.chapter6.item30.enums;

/**
 * The strategy enum pattern.
 */
public enum PayrollDay {
    MONDAY(PayType.WEEKDAY),
    TUESDAY(PayType.WEEKDAY),
    WEDNDESDAY(PayType.WEEKDAY),
    THURTHDAY(PayType.WEEKDAY),
    FRIDAY(PayType.WEEKDAY),
    SUTERDAY(PayType.WEEKEND),
    SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    double pay(double hours, double payRate) {
        return payType.pay(hours, payRate);
    }

    // The strategy enum type
    private enum PayType {
        WEEKDAY {
            @Override
            double overtimePay(double hours, double payRate) {
                return hours <= HOURS_PER_SHIFT ? 0 : (hours - HOURS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            @Override
            double overtimePay(double hours, double payRate) {
                return hours * payRate / 2;
            }
        };
        private static final int HOURS_PER_SHIFT = 8;

        abstract double overtimePay(double hours, double payRate);

        double pay(double hours, double payRate) {
            double basePay = hours * payRate;
            return basePay + overtimePay(hours, payRate);
        }
    }
}
