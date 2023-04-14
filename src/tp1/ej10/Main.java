package tp1.ej10;

public class Main {
    public static void main(String[] args) {
        Ordenado ordenado = new Ordenado();
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(ordenado.estaOrdenadoRecursivo(arr)); // true

        int[] arr2 = {1, 3, 2, 4, 5};
        System.out.println(ordenado.estaOrdenadoRecursivo(arr2)); // false
    }
}
