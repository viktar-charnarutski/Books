package effectivejava.chapter11.item78.serializationproxy;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Serializable class with Serialization proxy pattern instead of serialized instances.
 */
public class Period implements Serializable {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

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
