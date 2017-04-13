package chapter2.item5.staticinit;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * The class creates expensive objects of Calendar, TimeZone and Date only once, when it's initialized instead of
 * creating them every time {@code isBabyBoomer} invoked.
 */
public class Person {

    private final Date dateBirth;

    public Person(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    /**
     * Starting and ending dates ot he baby boom.
     */
    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    public boolean isBabyBoomer() {
        return dateBirth.compareTo(BOOM_START) >= 0 && dateBirth.compareTo(BOOM_END) < 0;
    }


}
