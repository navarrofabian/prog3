package tp1.ej10;

public class Ordenado {
    public boolean estaOrdenadoRecursivo(int[] arr) {
        if (arr.length <= 1) {
            return true;
        } else {
            return estaOrdenadoRecursivoAux(arr, 0);
        }
    }

    private boolean estaOrdenadoRecursivoAux(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        } else if (arr[i] > arr[i + 1]) {
            return false;
        } else {
            return estaOrdenadoRecursivoAux(arr, i + 1);
        }
    }
}