package tp2.quickSort;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 15, 10, 7, 8, 9, 1, 5 };
        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
