package learning.algorithms.sort;

import org.junit.Test;
import util.PrettyFormat;

public class MergeSort {
    public static void sort(int[] arr) {

    }


    @Test
    public void testSort() {
        int[] a = new int[]{6, 2, 7, 3, 5, 8, 1, 3};
        PrettyFormat.print(a);
        MergeSort.sort(a);
        PrettyFormat.print(a);

        a = new int[]{1, 5, 3, 7, 9};
        PrettyFormat.print(a);
        MergeSort.sort(a);
        PrettyFormat.print(a);

        a = new int[]{};
        PrettyFormat.print(a);
        MergeSort.sort(a);
        PrettyFormat.print(a);
    }
}
