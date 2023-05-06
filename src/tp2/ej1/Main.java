package tp2.ej1;
import java.util.List;
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
        bt.insert(1);

        System.out.println(bt.hasElem(8));
        System.out.println(bt.hasElem(14));
        System.out.println(bt.hasElem(5));
        System.out.print("La altura del arbol es: ");
        System.out.println(bt.getHeight());

        List<Integer> longestBranch = bt.getLongestBranch();
        System.out.println("Longest branch: " + longestBranch);

        List<Integer> hojas = bt.getFrontera();
        System.out.println("Hojas: " + hojas);
        System.out.println("max: " + bt.getMaxElem());
        System.out.println(("elementos en el nivel: " + bt.getElemAtLevel(3)));
        System.out.println("La suma total del arbol es: " + bt.sumaTotal());
    }
}
