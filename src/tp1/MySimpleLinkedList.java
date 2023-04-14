package tp1;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T> {

    private Node<T> first;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info,null);
        tmp.setNext(this.first);
        this.first = tmp;
        this.size++; // se aumenta el tamaño de la lista
    }

    public T extractFront() {
        if (isEmpty()) {
            return null;
        }
        T info = this.first.getInfo();
        this.first = this.first.getNext();
        this.size--; // se disminuye el tamaño de la lista
        return info;
    }

    public boolean isEmpty() {
        return (this.first == null);
    }

    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        Node<T> current = this.first;
        int i = 0;
        while (current != null && i < index) {
            current = current.getNext();
            i++;
        }
        if (current == null) {
            return null;
        }
        return current.getInfo();
    }

    public int size() {
        return this.size;
    }

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public int indexOf(T element) {
        int index = 0;
        Node<T> current = this.first;
        while (current != null && !current.getInfo().equals(element)) {
            current = current.getNext();
            index++;
        }
        if (current == null) {
            return -1;
        }
        return index;
    }

    @Override
    public String toString() {
        String str = "";
        Node<T> current = this.first;
        while (current != null) {
            str += current.getInfo().toString() + ", ";
            current = current.getNext();
        }
        return str;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(this.first);
    }
}
