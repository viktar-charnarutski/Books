package effectivejava.chapter7.item39.defensivecopies;


import java.sql.Date;

/**
 * Make defensive copies when needed.
 */
public class Period {
    private final Date start;
    private final Date end;

    // defensive copies are made before checking the validity of the parameters, and the validity check is performed on
    // copies rather than on the originals
    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.after(this.end)) throw new IllegalArgumentException("Start is after end.");
    }

    // return defensive copies of mutable internal fields
    public Date start() {
        return new Date(start.getTime());
    }
    
    // return defensive copies of mutable internal fields
    public Date end() {
        return new Date(end.getTime());
    }
}
