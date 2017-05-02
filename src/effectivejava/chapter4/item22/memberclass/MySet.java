package effectivejava.chapter4.item22.memberclass;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * Sample implementation of the {@code AbstractSet} interface with a non-static member class to implement it's
 * iterator.
 *
 * However, if the member class does not require an access to it's enclosing instance, this member class should be
 * <b>static</b>.
 */
public class MySet<E> extends AbstractSet<E> {

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    // a non-static member class
    private class MyIterator implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }

    @Override
    public int size() {
        return 0;
    }
}
