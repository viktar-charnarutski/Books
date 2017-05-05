package effectivejava.chapter5.item28.boundedwildcards;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

/**
 * Use bounded wildcards to increase API flexibility.
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

    public E pop() {
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

    public void pushAll(Iterable<? extends E> collection) {
        for (E obj : collection) {
            push(obj);
        }
    }

    public void popAll(Collection<? super E> collection) {
        while (!isEmpty()) {
            collection.add(pop());
        }
    }

    private boolean isEmpty() {
        return stack.length == 0;
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
