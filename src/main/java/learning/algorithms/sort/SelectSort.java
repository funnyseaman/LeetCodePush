package learning.algorithms.sort;

import org.junit.Test;
import util.PrettyFormat;

public class SelectSort {
    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    @Test
    public void testSort() {
        int[] a = new int[]{6, 2, 7, 3, 5, 8, 1, 3};
        PrettyFormat.printArray(a);
        SelectSort.sort(a);
        PrettyFormat.printArray(a);

        a = new int[]{1, 5, 3, 7, 9};
        PrettyFormat.printArray(a);
        SelectSort.sort(a);
        PrettyFormat.printArray(a);

        a = new int[]{};
        PrettyFormat.printArray(a);
        SelectSort.sort(a);
        PrettyFormat.printArray(a);
    }
}
