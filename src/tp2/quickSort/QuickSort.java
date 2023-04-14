package tp2.quickSort;

public class QuickSort {
    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right); // Paso 1: Elegir un pivote y colocarlo en su posición correcta
            quickSort(arr, left, pivotIndex - 1); // Paso 2: Ordenar los elementos menores al pivote
            quickSort(arr, pivotIndex + 1, right); // Paso 3: Ordenar los elementos mayores al pivote
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivotIndex = choosePivot(arr, left, right); // Elegir el pivote (por ejemplo, el primer elemento del subarreglo)
        int pivotValue = arr[pivotIndex]; // Obtener el valor del pivote
        swap(arr, pivotIndex, right); // Paso 1: Colocar el pivote al final del subarreglo

        int storeIndex = left; // El índice donde se irán colocando los elementos menores al pivote

        // Paso 2: Recorrer los elementos del subarreglo y colocar los menores al pivote antes de él
        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }

        swap(arr, storeIndex, right); // Paso 3: Colocar el pivote en su posición correcta
        return storeIndex; // Devolver la posición del pivote
    }

    private static int choosePivot(int[] arr, int left, int right) {
        return left; // En este ejemplo, el pivote es el primer elemento del subarreglo
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
