package learning.algorithms.sort;

import org.junit.Test;
import util.PrettyFormat;

public class QuickSort {

    public static void sort(int[] arr) {
        recursionSort(arr, 0, arr.length - 1);
    }

    // 递归函数
    private static void recursionSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(arr, start, end);
        recursionSort(arr, start, pivot - 1);
        recursionSort(arr, pivot + 1, end);
    }

    // 原地分区函数
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        arr[end] = arr[i];
        arr[i] = pivot;
        return i;
    }

    @Test
    public void testSort() {
        int[] a = new int[]{6, 2, 7, 3, 5, 8, 1, 3};
        PrettyFormat.print(a);
        QuickSort.sort(a);
        PrettyFormat.print(a);

        a = new int[]{1, 5, 3, 7, 9};
        PrettyFormat.print(a);
        QuickSort.sort(a);
        PrettyFormat.print(a);

        a = new int[]{};
        PrettyFormat.print(a);
        QuickSort.sort(a);
        PrettyFormat.print(a);
    }
}
