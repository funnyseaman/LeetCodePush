package learning.algorithms.sort;

import org.junit.Test;
import util.PrettyFormat;

public class ShellSort {
    public static void sort(int[] arr) {
        // 缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 插入排序
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j;
                for (j = i; j - gap >= 0 && tmp < (arr[j - gap]); j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = tmp;
            }
        }
    }


    @Test
    public void testSort() {
        int[] a = new int[]{6, 2, 7, 3, 5, 8, 1, 3};
        PrettyFormat.printArray(a);
        ShellSort.sort(a);
        PrettyFormat.printArray(a);

        a = new int[]{1, 5, 3, 7, 9};
        PrettyFormat.printArray(a);
        ShellSort.sort(a);
        PrettyFormat.printArray(a);

        a = new int[]{};
        PrettyFormat.printArray(a);
        ShellSort.sort(a);
        PrettyFormat.printArray(a);
    }
}
