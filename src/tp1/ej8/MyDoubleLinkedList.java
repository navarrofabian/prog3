package tp1.ej8;

public class MyDoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyDoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return (this.head == null);
    }

    public int size() {
        return this.size;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<T>(value, this.head, null);
        if (this.head != null) {
            this.head.setPrev(newNode);
        }
        this.head = newNode;
        if (this.tail == null) {
            this.tail = newNode;
        }
        this.size++;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<T>(value, null, this.tail);
        if (this.tail != null) {
            this.tail.setNext(newNode);
        }
        this.tail = newNode;
        if (this.head == null) {
            this.head = newNode;
        }
        this.size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            return;
        }
        this.head = this.head.getNext();
        if (this.head != null) {
            this.head.setPrev(null);
        } else {
            this.tail = null;
        }
        this.size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            return;
        }
        this.tail = this.tail.getPrev();
        if (this.tail != null) {
            this.tail.setNext(null);
        } else {
            this.head = null;
        }
        this.size--;
    }

    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return this.head.getValue();
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return this.tail.getValue();
    }

    public void printList() {
        Node<T> current = this.head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}