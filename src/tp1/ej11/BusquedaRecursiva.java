package tp1.ej11;

public class BusquedaRecursiva {

    public boolean buscarElemento(int[] arr, int elemento) {
        return buscarElementoAux(arr, elemento, 0, arr.length - 1);
    }

    private boolean buscarElementoAux(int[] arr, int elemento, int inicio, int fin) {
        if (inicio > fin) {
            return false;
        }

        int medio = (inicio + fin) / 2;

        if (arr[medio] == elemento) {
            return true;
        } else if (arr[medio] < elemento) {
            return buscarElementoAux(arr, elemento, medio + 1, fin);
        } else {
            return buscarElementoAux(arr, elemento, inicio, medio - 1);
        }
    }
}