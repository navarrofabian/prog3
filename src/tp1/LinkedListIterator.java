package tp1;

import java.util.Iterator;

public class LinkedListIterator<T> implements Iterator<T> {

    private Node<T> current;

    public LinkedListIterator(Node<T> first) {
        current = first;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        T item = current.getInfo();
        current = current.getNext();
        return item;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
