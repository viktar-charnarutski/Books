package effectivejava.chapter4.item16.composition;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Reusable forwarding class.
 */
public class ForwardingSet<E> implements Set<E> {

    private final Set<E> internalSet;

    public ForwardingSet(Set<E> internalSet) {
        this.internalSet = internalSet;
    }

    @Override
    public int size() {
        return internalSet.size();
    }

    @Override
    public boolean isEmpty() {
        return internalSet.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return internalSet.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return internalSet.iterator();
    }

    @Override
    public Object[] toArray() {
        return internalSet.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return internalSet.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return internalSet.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return internalSet.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return internalSet.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return internalSet.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return internalSet.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return internalSet.removeAll(c);
    }

    @Override
    public void clear() {
        internalSet.clear();
    }

    @Override
    public int hashCode() {
        return internalSet.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return internalSet.equals(obj);
    }

    @Override
    public String toString() {
        return internalSet.toString();
    }
}
