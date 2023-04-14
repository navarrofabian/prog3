package tp2.ej1;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        bt.insert(10);
        bt.insert(5);
        bt.insert(15);
        bt.insert(2);
        bt.insert(7);
        bt.insert(12);
        bt.insert(20);

        System.out.println("Árbol in-order: ");
        bt.inorderTraversal(bt.getRaiz());
    }
}
