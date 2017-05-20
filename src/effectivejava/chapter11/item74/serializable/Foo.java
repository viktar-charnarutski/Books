package effectivejava.chapter11.item74.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Serializable class of non-serializable stateful class.
 */
public class Foo extends AbstractFoo implements Serializable {

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();

        // manually deserialize and initialize superclass's object
        int x = s.readInt();
        int y = s.readInt();
        initialize(x, y);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();

        // manually serialize superclass's state
        s.writeInt(getX());
        s.writeInt(getY());
    }

    // constructor does not use the fancy mechanism
    public Foo(int x, int y) {
        super(x, y);
    }

    private static final long serialVersionUID = 586838560954L;
}
