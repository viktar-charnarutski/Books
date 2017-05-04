package effectivejava.chapter5.item26.generictypes;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Generified Stack.
 */
public class Stack<E> {

    private E[] stack;
    private int size = 0;
    private static final int INITIAL_CAPACITY = 16;

    // The stack array will contains only E instances from push(E).
    // This is sufficient to ensure type safety, but the runtime
    // type of the array won't be E[]: it will always be Object.
    @SuppressWarnings("unchecked")
    public Stack() {
        stack = (E[]) new Object[INITIAL_CAPACITY];
    }

    public void push(E obj) {
        ensureCapacity();
        stack[size] = obj;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E obj = stack[--size];
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
