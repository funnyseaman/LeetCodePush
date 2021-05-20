package learning.algorithms.sort;

import org.junit.Test;
import util.PrettyFormat;

public class MergeSort {
    public static void sort(int[] arr, int[] result) {
        assistSort(arr, result, 0, arr.length - 1);
    }

    private static void assistSort(int[] arr, int[] result, int start, int end) {

    }


    @Test
    public void testSort() {
        int[] a = new int[]{6, 2, 7, 3, 5, 8, 1, 3};
        PrettyFormat.print(a);
        int[] result = new int[a.length];
        MergeSort.sort(a, result);
        PrettyFormat.print(result);

        a = new int[]{1, 5, 3, 7, 9};
        PrettyFormat.print(a);
        result = new int[a.length];
        MergeSort.sort(a, result);
        PrettyFormat.print(result);

        a = new int[]{};
        PrettyFormat.print(a);
        result = new int[a.length];
        MergeSort.sort(a, result);
        PrettyFormat.print(result);
    }
}
