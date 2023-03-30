package tp1;

public class Stack<T> {

    private MySimpleLinkedList<T> list;

    public Stack() {
        this.list = new MySimpleLinkedList<T>();
    }

    public void push(T item) {
        this.list.insertFront(item);
    }

    public T pop() {
        T item = this.list.extractFront();
        return item;
    }

    public T top() {
        if (this.isEmpty()) {
            return null;
        }
        T item = this.list.get(0);
        return item;
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int size() {
        return this.list.size();
    }

    public void reverse() {
        Node<T> prev = null;
        Node<T> current = this.list.getFirst();
        Node<T> next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        this.list.setFirst(prev);
    }

    @Override
    public String toString() {
        return this.list.toString();
    }
}