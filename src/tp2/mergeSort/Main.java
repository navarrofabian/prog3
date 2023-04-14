package tp2.mergeSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10, 2};
        System.out.println("Array desordenado: " + Arrays.toString(arr));

        MergeSort.sort(arr);
        System.out.println("Array ordenado: " + Arrays.toString(arr));
    }
}
