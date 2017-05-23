package effectivejava.chapter11.item78.serializationproxy;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.sql.Date;

/**
 * Serializable class with Serialization proxy pattern instead of serialized instances.
 */
public class Period implements Serializable {
    private final Date start;
    private final Date end;

    // defensive copies are made before checking the validity of the parameters, and the validity check is performed on
    // copies rather than on the originals
    public Period(Date start, Date end) {
        this.start = new java.sql.Date(start.getTime());
        this.end = new java.sql.Date(end.getTime());
        if (this.start.after(this.end)) throw new IllegalArgumentException("Start is after end");
    }

    // return defensive copies of mutable internal fields
    public Date start() {
        return new Date(start.getTime());
    }

    // return defensive copies of mutable internal fields
    public Date end() {
        return new Date(end.getTime());
    }

    // Serialization proxy pattern
    private static class SerializableProxy implements Serializable {
        private final Date start;
        private final Date end;

        SerializableProxy(Period period) {
            this.start = period.start;
            this.end = period.end;
        }

        private static final long serialVersionUID = 2432434515125464L;
    }

    private Object writeReplace() {
        return new SerializableProxy(this);
    }

    private Object readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }

    private Object readResolve() {
        return new Period(start, end);
    }
}
