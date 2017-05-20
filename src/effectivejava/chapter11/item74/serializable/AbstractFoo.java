package effectivejava.chapter11.item74.serializable;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Nonserializable stateful class allowing serializable subclass.
 */
public class AbstractFoo {
    private int x, y; // our state

    // this enum and field are used to track initialization
    private enum State {
        NEW, INITIALIZING, INITIALIZED
    }

    private final AtomicReference<State> init = new AtomicReference<>(State.NEW);

    public AbstractFoo(int x, int y) {
        initialize(x, y);
    }

    // this empty constructor and following method allow subclass's readObject method to initialize out state
    public AbstractFoo() {
    }

    protected final void initialize(int x, int y) {
        if (!init.compareAndSet(State.NEW, State.INITIALIZING)) {
            throw new IllegalStateException("Already initialized");
        }
        this.x = x;
        this.y = y;
        init.set(State.INITIALIZED);
    }

    // these methods provide access to internal state so it manually could be serialized by subclass's writeObject
    // method
    protected final int getX() {
        return x;
    }

    protected final int getY() {
        return y;
    }

    // must be called from all public and protected instance methods
    private void checkInit() {
        if (init.get() != State.INITIALIZED) {
            throw new IllegalStateException("Uninitialized");
        }
    }
}
