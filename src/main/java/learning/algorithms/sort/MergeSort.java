package learning.algorithms.sort;

import org.junit.Test;
import util.PrettyFormat;

public class MergeSort {
    public static int[] assistArr;

    // 归并排序
    public static void sort(int[] arr) {
        assistArr = new int[arr.length];
        assistSort(arr, 0, arr.length - 1);
    }

    // 递归过程
    private static void assistSort(int[] arr, int start, int end) {
        if (end - start < 1) {
            return;
        }
        int mid = (start + end) / 2;
        assistSort(arr, start, mid);
        assistSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    // 合并数组
    private static void merge(int[] arr, int start, int mid, int end) {
        // 把范围内的arr复制到assistArr中
        if (end + 1 - start >= 0) System.arraycopy(arr, start, assistArr, start, end + 1 - start);
        int result_current = start;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            if (assistArr[left] <= assistArr[right]) {
                arr[result_current] = assistArr[left];
                left++;
            } else {
                arr[result_current] = assistArr[right];
                right++;
            }
            result_current++;
        }
        if (left > mid) {
            for (; right <= end; right++) {
                arr[result_current] = assistArr[right];
                result_current++;
            }
        }
        if (right > end) {
            for (; left <= mid; left++) {
                arr[result_current] = assistArr[left];
                result_current++;
            }
        }
    }


    @Test
    public void testSort() {
        int[] a = new int[]{6, 2, 7, 3, 5, 8, 1, 3};
        PrettyFormat.print(a);
        MergeSort.sort(a);
        PrettyFormat.print(a);

        a = new int[]{6, 2, 7, 3, 5, 8, 1};
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
