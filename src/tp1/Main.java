package tp1;

public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> list = new MySimpleLinkedList<>();
        list.insertFront(1);
        list.insertFront(2);
        list.insertFront(3);

        for (Integer element : list) {
            System.out.println(element);
        }
    }
}
