package effectivejava.chapter2.item6.refferences;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 2.
 * <p>
 * A memory leak could be by {@code pop} method if poped object, which could has an obsolete reference, was not
 * nullified.
 */
public class Stack {
    private Object[] stack;
    private int size = 0;
    private static final int INITIAL_CAPACITY = 16;

    public Stack() {
        stack = new Object[INITIAL_CAPACITY];
    }

    public void push(Object obj) {
        ensureCapacity();
        stack[size] = obj;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object obj = stack[--size];
        stack[size] = null; // eliminate obsolete reference
        return obj;
    }

    private void ensureCapacity() {
        if (size == INITIAL_CAPACITY) {
            stack = Arrays.copyOf(stack, size * 2 + 1);
        }
    }

    @Override
    protected Stack clone() {
        try {
            Stack result = (Stack) super.clone();
            result.stack = stack.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
